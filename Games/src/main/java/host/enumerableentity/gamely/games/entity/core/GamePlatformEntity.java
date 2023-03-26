package host.enumerableentity.gamely.games.entity.core;

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
@Table(name = "GAME_PLATFORMS")
@FieldNameConstants
@ToString
public class GamePlatformEntity implements Serializable {
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
    @Column(name = "HOLDER", length = 100)
    private String holder;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "platforms")
    @ToString.Exclude
    private Set<VideoGameEntity> videoGames = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        GamePlatformEntity that = (GamePlatformEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
