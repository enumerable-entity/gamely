package host.enumerableentity.gamely.games.repository;

import host.enumerableentity.gamely.games.entity.CompletionKey;
import host.enumerableentity.gamely.games.entity.UserGameRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGameRecordEntityRepository extends JpaRepository<UserGameRecordEntity, CompletionKey> {
}
