package by.itstep.viarzilin.domain;


import by.itstep.viarzilin.domain.AbstractClasses.AbstractEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends AbstractEntity implements UserDetails {


    @NotBlank(message = "Username can't be empty")
    private String username;

    @NotBlank(message = "Password confirmation can't be empty")
    private String password;

    private boolean active;

    @Email(message = "Email is not correct")
    @NotBlank(message = "Email can't be empty")
    private String email;

    private String activationCode;

    @ElementCollection(targetClass = Roles.class, fetch = FetchType.EAGER)
    @CollectionTable(name="user_role", joinColumns = @JoinColumn(name="user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Roles> roles;

    public boolean isAdmin(){
        return roles.contains(Roles.ADMIN);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof User)) return false;
//        if (!super.equals(o)) return false;
//        User user = (User) o;
//        return Objects.equals(userId(), user.userId());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(userId());
//    }
}
