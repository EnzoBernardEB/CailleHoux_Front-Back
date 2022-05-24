package fr.ecommerce.caillehoux.controller.appUser;

import fr.ecommerce.caillehoux.DTO.authentication.request.LoginRequest;
import fr.ecommerce.caillehoux.DTO.authentication.request.SignupRequest;
import fr.ecommerce.caillehoux.DTO.authentication.response.JwtResponse;
import fr.ecommerce.caillehoux.DTO.authentication.response.MessageResponse;
import fr.ecommerce.caillehoux.controller.appUser.strategies.rolesStrategies.RoleStrategie;
import fr.ecommerce.caillehoux.entity.appUser.AppRole;
import fr.ecommerce.caillehoux.entity.appUser.AppUser;
import fr.ecommerce.caillehoux.domaineService.appUser.AppUserServiceImpl;
import fr.ecommerce.caillehoux.repository.appUser.AppUserRepository;
import fr.ecommerce.caillehoux.security.JWT.JwtUtils;
import fr.ecommerce.caillehoux.security.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin()
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    AppUserRepository userRepository;
    @Autowired
    Collection<RoleStrategie> collectionRoleStrategies;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    AppUserServiceImpl clientService;


    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }
        AppUser user = new AppUser(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));
        Set<String> strRoles = signUpRequest.getRole();

        Optional<RoleStrategie> strategieTarget = collectionRoleStrategies.stream().filter(strategie -> strategie.hasRole(strRoles)).findFirst();
        Set<AppRole> roles = new HashSet<>(strategieTarget.get().getRoles());

        user.setRoles(roles);
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}