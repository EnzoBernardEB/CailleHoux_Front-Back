package fr.ecommerce.caillehoux.controller.appUser.strategies.rolesStrategies;

import fr.ecommerce.caillehoux.domaineService.appUser.AppRoleService;
import fr.ecommerce.caillehoux.entity.appUser.AppRole;
import fr.ecommerce.caillehoux.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Component
public class ClientRoleStrategie implements RoleStrategie{
    @Autowired
    AppRoleService appRoleService;

    @Override
    public Boolean hasRole(Set<String> role) {
        if(role.contains("CLIENT") && role.size()==1) {
            return true;
        }
        return false;
    }

    @Override
    public Collection<AppRole> getRoles() {
        Collection<AppRole> roles = new ArrayList<AppRole>();
        roles.add(appRoleService.getRoleByName(Role.ROLE_ADMIN));
        roles.add(appRoleService.getRoleByName(Role.ROLE_SELLER));

        return roles;
    }
}
