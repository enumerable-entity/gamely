package host.enumerableentity.gamely.games.repository;

import host.enumerableentity.gamely.games.entity.core.VideoGameEntity;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoGameRepository extends JpaRepository<VideoGameEntity, Long> {

    @Override
    @EntityGraph(attributePaths = {"platforms"})
    Page<VideoGameEntity> findAll(@NotNull Pageable paginationInfo);

}
