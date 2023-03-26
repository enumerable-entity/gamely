package host.enumerableentity.gamely.games.repository;

import host.enumerableentity.gamely.games.entity.core.GamePlatformEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamePlatformRepository extends JpaRepository<GamePlatformEntity, Long> {
}
