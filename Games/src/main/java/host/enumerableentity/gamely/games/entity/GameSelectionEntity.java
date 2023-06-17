package host.enumerableentity.gamely.games.entity;

import host.enumerableentity.gamely.games.entity.core.WalkthroughEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Setter
@Builder
@Table(name = "USER_SELECTION")
@FieldNameConstants
@ToString
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class GameSelectionEntity implements Serializable {
    @EmbeddedId
    private SelectionKey selectionKey;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "GAME_CATEGORY_ID")
    @ToString.Exclude
    private GameCategoryEntity category;

    @ToString.Exclude
    @OneToMany(mappedBy = "gameSelection", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<WalkthroughEntity> completions;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        GameSelectionEntity that = (GameSelectionEntity) o;
        return getSelectionKey() != null && Objects.equals(getSelectionKey(), that.getSelectionKey());
    }

    @Override
    public int hashCode() {
        return Objects.hash(selectionKey);
    }
}


