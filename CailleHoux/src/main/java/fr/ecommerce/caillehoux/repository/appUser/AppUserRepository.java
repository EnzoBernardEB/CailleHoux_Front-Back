package fr.ecommerce.caillehoux.repository.appUser;

import fr.ecommerce.caillehoux.entity.appUser.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Long> {
   Optional<AppUser> findByEmailAndPassword(String name, String password);
   Optional<AppUser> findByEmail(String name);
   Optional<AppUser> findByUsername(String username);
   Boolean existsByUsername(String username);
   Boolean existsByEmail(String email);
}
