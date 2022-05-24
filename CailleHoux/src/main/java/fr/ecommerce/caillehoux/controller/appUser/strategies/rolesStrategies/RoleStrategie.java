package fr.ecommerce.caillehoux.controller.appUser.strategies.rolesStrategies;

import fr.ecommerce.caillehoux.entity.appUser.AppRole;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public interface RoleStrategie {
    Boolean hasRole(Set<String> role);
    Collection<AppRole> getRoles();
}
