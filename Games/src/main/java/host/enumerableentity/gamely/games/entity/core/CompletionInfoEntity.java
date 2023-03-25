package host.enumerableentity.gamely.games.entity.core;


import host.enumerableentity.gamely.games.entity.UserGameRecordEntity;
import host.enumerableentity.gamely.games.kafka.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import static jakarta.persistence.GenerationType.AUTO;

@Getter
@Setter
@Entity
@Table(name = "COMPLETION_INFO")
@FieldNameConstants
@ToString
public class CompletionInfoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "DATE", nullable = true)
    private LocalDate date;
    @Column(name = "DURATION", nullable = true)
    private Integer duration;
    @Column(name = "PIRATED", nullable = true)
    private Boolean pirated;
    @Column(name = "USER_LINK", length = 250)
    private String userLink;
    @Column(name = "USER_NOTES", length = 1000)
    private String userNotes;
    @Column(name = "USER_COOP_NICKNAME", length = 30)
    private String externalUsernameCoop;

    @ToString.Exclude
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_COOP_ID")
    private UserEntity internalUserCoop;
    @ToString.Exclude
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "PLATFORM_ID")
    private GamePlatformEntity platform;

    @ToString.Exclude
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    @JoinColumn(name = "VIDEO_GAME_ID", nullable = false)
    private UserGameRecordEntity userGameRecordEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CompletionInfoEntity that = (CompletionInfoEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
