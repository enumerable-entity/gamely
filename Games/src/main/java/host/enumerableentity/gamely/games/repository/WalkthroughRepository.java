package host.enumerableentity.gamely.games.repository;

import host.enumerableentity.gamely.games.entity.core.WalkthroughEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalkthroughRepository extends JpaRepository<WalkthroughEntity, Long> {
}
