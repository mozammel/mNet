package org.jugbd.mnet.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "findByUsername", query = "select u from User u left join fetch u.authorities where u.username = (:username)"),
        @NamedQuery(name = "findAllUsers", query = "select  u from  User u")
})
public class User extends Persistence implements UserDetails, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Version
    private Long version;
    @Size(min = 4, max = 30)
    @NotNull
    @Column(nullable = false)
    private String username;
    @NotNull
    @Min(8)
    @Column(nullable = false)
    private String password;
    @Transient
    private String passwordConfirmed;
    private String email;
    private String phoneNumber;
    @Basic(fetch = FetchType.LAZY)
    @ElementCollection(targetClass = Role.class)
    @Enumerated(EnumType.STRING) // Possibly optional (I'm not sure) but defaults to ORDINAL.
    @CollectionTable(name = "user_role")
    private List<Role> authorities;

    //spring security default properties
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : this.authorities) {
            authorities.add(new SimpleGrantedAuthority(role.name()));
        }
        return authorities;
    }

    public void setAuthorities(List<Role> authorities) {
        this.authorities = authorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPasswordConfirmed() {
        return passwordConfirmed;
    }

    public void setPasswordConfirmed(String passwordConfirmed) {
        this.passwordConfirmed = passwordConfirmed;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (accountNonExpired != user.accountNonExpired) return false;
        if (accountNonLocked != user.accountNonLocked) return false;
        if (credentialsNonExpired != user.credentialsNonExpired) return false;
        if (enabled != user.enabled) return false;
        if (id != user.id) return false;
        if (authorities != null ? !authorities.equals(user.authorities) : user.authorities != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (!password.equals(user.password)) return false;
        if (passwordConfirmed != null ? !passwordConfirmed.equals(user.passwordConfirmed) : user.passwordConfirmed != null)
            return false;
        if (phoneNumber != null ? !phoneNumber.equals(user.phoneNumber) : user.phoneNumber != null) return false;
        if (!username.equals(user.username)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (accountNonExpired ? 1 : 0);
        result = 31 * result + (accountNonLocked ? 1 : 0);
        result = 31 * result + (credentialsNonExpired ? 1 : 0);
        result = 31 * result + (enabled ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", enabled=" + enabled +
                '}';
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
