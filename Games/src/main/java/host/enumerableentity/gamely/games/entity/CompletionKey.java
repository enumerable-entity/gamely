package host.enumerableentity.gamely.games.entity;

import host.enumerableentity.gamely.games.entity.core.VideoGameEntity;
import host.enumerableentity.gamely.games.kafka.entity.UserEntity;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
@FieldNameConstants
public class CompletionKey implements Serializable {
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "VIDEO_GAME_ID")
    private VideoGameEntity game;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CompletionKey that = (CompletionKey) o;
        return getUser() != null && Objects.equals(getUser(), that.getUser())
                && getGame() != null && Objects.equals(getGame(), that.getGame());
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, game);
    }
}
