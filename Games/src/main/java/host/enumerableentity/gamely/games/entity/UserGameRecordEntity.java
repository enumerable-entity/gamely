package host.enumerableentity.gamely.games.entity;

import host.enumerableentity.gamely.games.entity.core.CompletionInfoEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Setter
@Table(name = "USER_SELECTION")
@FieldNameConstants
@ToString
@Getter
@Entity
public class UserGameRecordEntity implements Serializable {
    @EmbeddedId
    private CompletionKey completionKey;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "GAME_CATEGORY_ID")
    private GameCategoryEntity category;

    @ToString.Exclude
    @OneToMany(mappedBy = "userGameRecordEntity", cascade = {CascadeType.REMOVE, CascadeType.DETACH},
            orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<CompletionInfoEntity> completions;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserGameRecordEntity that = (UserGameRecordEntity) o;
        return getCompletionKey() != null && Objects.equals(getCompletionKey(), that.getCompletionKey());
    }

    @Override
    public int hashCode() {
        return Objects.hash(completionKey);
    }
}


