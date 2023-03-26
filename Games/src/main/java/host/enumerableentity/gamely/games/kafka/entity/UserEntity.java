package host.enumerableentity.gamely.games.kafka.entity;

import host.enumerableentity.gamely.games.entity.GameCategoryEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "USERS_SYNC")
@FieldNameConstants
@ToString
public class UserEntity implements Serializable {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "IS_DELETED", nullable = false)
    private Boolean isDeleted = false;

    @Column(name = "USERNAME", nullable = false, length = 30)
    private String username;

    @ToString.Exclude
    @OneToMany(mappedBy = "user", cascade = {CascadeType.REMOVE, CascadeType.DETACH}, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<GameCategoryEntity> categories = new LinkedHashSet<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserEntity that = (UserEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
