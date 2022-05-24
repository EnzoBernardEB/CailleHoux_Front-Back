package fr.ecommerce.caillehoux.controller.appUser;

import fr.ecommerce.caillehoux.entity.appUser.AppUser;
import fr.ecommerce.caillehoux.repository.appUser.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    AppUserRepository appUserRepository;

    @GetMapping("/")
    public List<AppUser> index() {
        return appUserRepository.findAll();
    }
}
