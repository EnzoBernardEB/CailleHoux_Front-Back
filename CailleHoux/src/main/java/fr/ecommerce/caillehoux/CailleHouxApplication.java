package fr.ecommerce.caillehoux;

import fr.ecommerce.caillehoux.controller.appUser.strategies.rolesStrategies.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@SpringBootApplication
public class CailleHouxApplication {

    public static void main(String[] args) {
        SpringApplication.run(CailleHouxApplication.class, args);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public Collection<RoleStrategie> collectionRoleStrategies(ClientRoleStrategie clientRoleStrategie, AdminRoleStrategie adminRoleStrategie, SellerRoleStrategie sellerRoleStrategie, EmptyRoleStrategie emptyRoleStrategie) {
        Collection<RoleStrategie> roleStrategies = new ArrayList<>();
        roleStrategies.add(adminRoleStrategie);
        roleStrategies.add(clientRoleStrategie);
        roleStrategies.add(sellerRoleStrategie);
        roleStrategies.add(emptyRoleStrategie);

        return roleStrategies;
    }
}
