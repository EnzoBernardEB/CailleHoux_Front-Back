package fr.ecommerce.caillehoux.domaineService.appUser;

import fr.ecommerce.caillehoux.entity.appUser.AppRole;
import fr.ecommerce.caillehoux.entity.appUser.AppUser;
import fr.ecommerce.caillehoux.exception.ResourceNotFoundException;
import fr.ecommerce.caillehoux.model.Role;
import fr.ecommerce.caillehoux.repository.appUser.AppRoleRepository;
import fr.ecommerce.caillehoux.repository.appUser.AppUserRepository;
import fr.ecommerce.caillehoux.security.model.ActiveUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("roles")
public class AppRoleServiceImpl implements AppRoleService {

    @Autowired
    AppRoleRepository appRoleRepository;

    public AppRoleRepository getRoleRepository() {
        return this.appRoleRepository;
    }

    public void setRoleRepository(AppRoleRepository appRoleRepository) {
        this.appRoleRepository = appRoleRepository;
    }

    @Override
    public List<AppRole> getAllRoles() {
        return appRoleRepository.findAll();
    }

    @Override
    public AppRole getRoleByName(Role role) {
        Optional<AppRole> result = appRoleRepository.findByName(role);
        if(result.isPresent()) {
            return result.get();
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @Override
    public AppRole save(AppRole role) {
        AppRole result = appRoleRepository.save(role);
        return result;    }
}
