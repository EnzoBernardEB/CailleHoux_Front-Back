package fr.ecommerce.caillehoux.controller.appUser.strategies.rolesStrategies;

import fr.ecommerce.caillehoux.domaineService.appUser.AppRoleService;
import fr.ecommerce.caillehoux.entity.appUser.AppRole;
import fr.ecommerce.caillehoux.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Component
public class EmptyRoleStrategie implements RoleStrategie{
    @Autowired
    AppRoleService roles;

    public EmptyRoleStrategie() {
    }

    public EmptyRoleStrategie(AppRoleService appRoleService) {
        this.roles = appRoleService;
    }

    public AppRoleService getAppRoleService() {
        return roles;
    }

    public void setAppRoleService(AppRoleService appRoleService) {
        this.roles = appRoleService;
    }

    @Override
    public Boolean hasRole(Set<String> role) {
        if(role.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public Collection<AppRole> getRoles() {
        Collection<AppRole> rolesTarget = new ArrayList<AppRole>();
        rolesTarget.add(roles.getRoleByName(Role.ROLE_CLIENT));

        return rolesTarget;
    }
}
