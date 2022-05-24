package fr.ecommerce.caillehoux.entity.appUser;

import fr.ecommerce.caillehoux.model.Role;

import javax.persistence.*;

@Entity
@Table(name = "app_role")
public class AppRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Role name;
    public AppRole() {
    }
    public AppRole(Role name) {
        this.name = name;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Role getName() {
        return name;
    }
    public void setName(Role name) {
        this.name = name;
    }
}