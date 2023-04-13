package host.enumerableentity.gamely.auth.entity;

import host.enumerableentity.gamely.auth.commons.Role;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Entity(name = "SYSTEM_USER")
@Getter
@Setter
@Builder
@FieldNameConstants
@NoArgsConstructor
@AllArgsConstructor
@Table(indexes = {@Index(name = "SYSTEM_USER_USERNAME_IDX", columnList = "USERNAME", unique = true),
                    @Index(name = "SYSTEM_USER_EMAIL_IDX", columnList = "EMAIL", unique = true)})
public class SystemUserEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @Column(name = "USERNAME", nullable = false, unique = true, updatable = false)

    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "FIRST_NAME", nullable = true)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = true)
    private String lastName;

    @Column(name = "AVATAR_LINK", nullable = true)
    private String avatarLink;

    @Builder.Default
    @Column(name = "IS_ENABLED", nullable = false)
    private boolean isEnabled = true;

    @Builder.Default
    @Column(name = "IS_ACCOUNT_NON_EXPIRED", nullable = false)
    private boolean isAccountNonExpired = true;

    @Builder.Default
    @Column(name = "IS_ACCOUNT_NON_LOCKED", nullable = false)
    private boolean isAccountNonLocked = true;

    @Builder.Default
    @Column(name = "ROLE", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Set.of(role);
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
