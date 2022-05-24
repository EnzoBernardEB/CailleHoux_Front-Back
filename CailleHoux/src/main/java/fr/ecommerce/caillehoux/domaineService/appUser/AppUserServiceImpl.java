package fr.ecommerce.caillehoux.domaineService.appUser;

import fr.ecommerce.caillehoux.security.model.ActiveUser;
import fr.ecommerce.caillehoux.exception.ResourceNotFoundException;
import fr.ecommerce.caillehoux.entity.appUser.AppUser;
import fr.ecommerce.caillehoux.repository.appUser.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("clients")
public class AppUserServiceImpl implements AppUserService, UserDetailsService {

    @Autowired
    AppUserRepository appUserRepository;

    public AppUserRepository getClientRepository() {
        return appUserRepository;
    }

    public void setClientRepository(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }
    @Override
    public List<AppUser> getAllClient() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser getClientById(Long clientId) {
        Optional<AppUser> result = appUserRepository.findById(clientId);
        if(result.isPresent()) {
            return result.get();
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @Override
    public AppUser save(AppUser appUser) {
       AppUser result = appUserRepository.save(appUser);
        return result;
    }

    @Override
    public Optional<AppUser> authenticated(AppUser appUser) {
        return appUserRepository.findByEmailAndPassword(appUser.getEmail(), appUser.getPassword());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> user = appUserRepository.findByUsername(username);
        if(user.isPresent()) {
            return new ActiveUser(user.get());
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
}
