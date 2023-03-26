package host.enumerableentity.gamely.games.repository;

import host.enumerableentity.gamely.games.entity.SelectionKey;
import host.enumerableentity.gamely.games.entity.GameSelectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameSelectionRepository extends JpaRepository<GameSelectionEntity, SelectionKey> {
}
