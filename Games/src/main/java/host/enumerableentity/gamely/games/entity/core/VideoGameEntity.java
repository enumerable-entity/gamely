package host.enumerableentity.gamely.games.entity.core;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import static jakarta.persistence.GenerationType.AUTO;

@Getter
@Setter
@Entity
@Table(name = "VIDEO_GAMES")
@FieldNameConstants
@ToString
public class VideoGameEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;
    @Column(name = "IS_DELETED", nullable = false)
    private Boolean isDeleted = false;

    @Column(name = "TITLE", nullable = false, length = 100)
    private String title;
    @Column(name = "RELEASE_DATE")
    private LocalDate releaseDate;
    @Column(name = "LOGO_LINK", length = 250)
    private String logoLink;
    @Column(name = "DESCRIPTION", length = 1000)
    private String description;
    @Column(name = "WIKI_LINK", length = 250)
    private String wikiLink;

    @ManyToMany(mappedBy = "videoGames", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<GamePlatformEntity> gamePlatforms = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        VideoGameEntity that = (VideoGameEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
