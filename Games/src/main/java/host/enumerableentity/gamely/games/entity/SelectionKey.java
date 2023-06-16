package host.enumerableentity.gamely.games.entity;

import host.enumerableentity.gamely.games.entity.core.VideoGameEntity;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
@FieldNameConstants
@NoArgsConstructor
@AllArgsConstructor
public class SelectionKey implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private UserEntity user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "VIDEO_GAME_ID")
    private VideoGameEntity game;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SelectionKey that = (SelectionKey) o;
        return getUser() != null && Objects.equals(getUser(), that.getUser())
                && getGame() != null && Objects.equals(getGame(), that.getGame());
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, game);
    }
}
