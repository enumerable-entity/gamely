package host.enumerableentity.gamely.games.entity;

import host.enumerableentity.gamely.games.kafka.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "GAME_CATEGORIES")
@FieldNameConstants
@ToString
public class GameCategoryEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "IS_DELETED", nullable = false)
    private Boolean isDeleted = false;
    @Column(name = "TITLE", nullable = false, length = 100)
    private String title;
    @Column(name = "LOGO_LINK", length = 250)
    private String logoLink;
    @Column(name = "DESCRIPTION", length = 500)
    private String description;

    @ToString.Exclude
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserEntity user;

    @Column(name = "USER_ID", nullable = false, insertable = false, updatable = false)
    private Long userId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        GameCategoryEntity that = (GameCategoryEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
