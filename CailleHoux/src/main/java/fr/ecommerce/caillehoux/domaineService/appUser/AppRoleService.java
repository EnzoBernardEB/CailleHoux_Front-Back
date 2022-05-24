package fr.ecommerce.caillehoux.domaineService.appUser;

import fr.ecommerce.caillehoux.entity.appUser.AppRole;
import fr.ecommerce.caillehoux.model.Role;

import java.util.List;

public interface AppRoleService {
    public List<AppRole> getAllRoles();
    public AppRole getRoleByName(Role role);
    public AppRole save(AppRole approle);
}
