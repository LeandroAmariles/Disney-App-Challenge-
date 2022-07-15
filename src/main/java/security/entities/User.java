package security.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(generator="UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private long id;

    @NotNull
    @Column(unique = true)
    private String userName;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String Password;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    // This table is to identify the rol for each user and the user can have one rol or more
    @JoinTable(name="user_role", joinColumns = @JoinColumn(name= "user_id"), inverseJoinColumns = @JoinColumn(name ="role_id"))
    private transient Set<Role> roles = new HashSet<>();

    public User(){

    }

    public User(String userName, String email, String password, Set<Role> roles) {
        this.userName = userName;
        this.email = email;
        Password = password;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
