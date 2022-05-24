package fr.ecommerce.caillehoux.domaineService.appUser;

import fr.ecommerce.caillehoux.entity.appUser.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserService {
    public List<AppUser> getAllClient();
    public AppUser getClientById(Long clientId);
    public AppUser save(AppUser appUser);
    public Optional<AppUser> authenticated(AppUser appUser);
}
