package security.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

// This class allow us to identify the authority throw the role
//it allows us to restrict some actions for each rol

public class MainUser implements UserDetails {

    private String userName;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public MainUser(String userName, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static MainUser Build(User user ){
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role-> new SimpleGrantedAuthority(role.getRoleName().name())).collect(Collectors.toList());
        return new MainUser(user.getUserName(), user.getEmail(), user.getPassword(),authorities);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
