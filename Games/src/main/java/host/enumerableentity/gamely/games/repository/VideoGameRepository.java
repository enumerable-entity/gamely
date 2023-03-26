package host.enumerableentity.gamely.games.repository;

import host.enumerableentity.gamely.games.entity.core.VideoGameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoGameRepository extends JpaRepository<VideoGameEntity, Long> {

}
