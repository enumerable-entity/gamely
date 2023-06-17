package host.enumerableentity.gamely.games.entity.core;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;
import org.hibernate.Hibernate;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import static jakarta.persistence.GenerationType.AUTO;

@Indexed(index = "games_idx", backend = "lucene")
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
    @FullTextField
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "GAME_PLATFORMS_TO_VIDEO_GAMES",
            joinColumns = @JoinColumn(name = "VIDEO_GAME_ID", referencedColumnName = "ID", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "GAME_PLATFORM_ID", referencedColumnName = "ID", nullable = false))
    @ToString.Exclude
    private Set<GamePlatformEntity> platforms = new LinkedHashSet<>();

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
