package fr.ecommerce.caillehoux.entity.appUser;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "app_user")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String username;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<AppRole> roles = new HashSet<>();

    public AppUser() {
        super();
    }

    public AppUser( String username, String email, String password) {
        super();
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public Long getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }
     public String getUsername() {return this.username;}

    public String getPassword() {
        return this.password;
    }
    public Set<AppRole> getRoles() {
        return roles;
    }
    public void setRoles(Set<AppRole> roles) {
        this.roles = roles;
    }
    @Override
    public String toString() {
        return "Client [id=" + this.id + ", username=" + this.email + ", password=" + this.password + "]";
    }

}
