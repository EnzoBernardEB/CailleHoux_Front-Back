package fr.ecommerce.caillehoux.repository.appUser;

import fr.ecommerce.caillehoux.entity.appUser.AppRole;
import fr.ecommerce.caillehoux.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
    Optional<AppRole> findByName(Role name);

}
