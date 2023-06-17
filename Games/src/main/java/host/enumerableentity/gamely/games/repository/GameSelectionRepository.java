package host.enumerableentity.gamely.games.repository;

import host.enumerableentity.gamely.games.entity.GameSelectionEntity;
import host.enumerableentity.gamely.games.entity.SelectionKey;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameSelectionRepository extends JpaRepository<GameSelectionEntity, SelectionKey> {

    @EntityGraph(attributePaths = {"category", "completions.internalUserCoop", "completions.platform"})
    List<GameSelectionEntity> findAllBySelectionKeyUserId(Long userId);

    @EntityGraph(attributePaths = {"category", "completions.internalUserCoop", "completions.platform"})
    List<GameSelectionEntity> findAllBySelectionKey_UserId(Long userId);
}
