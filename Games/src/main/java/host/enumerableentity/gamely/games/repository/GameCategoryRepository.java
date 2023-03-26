package host.enumerableentity.gamely.games.repository;

import host.enumerableentity.gamely.games.commons.DictionaryDTO;
import host.enumerableentity.gamely.games.entity.GameCategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameCategoryRepository extends JpaRepository<GameCategoryEntity, Long> {
    Page<GameCategoryEntity> findAllByUserId(Long userId, Pageable paginationInfo);

    @Query("SELECT new host.enumerableentity.gamely.games.commons.DictionaryDTO(c.id, c.title) FROM GameCategoryEntity c")
    List<DictionaryDTO> getDictionary();
}
