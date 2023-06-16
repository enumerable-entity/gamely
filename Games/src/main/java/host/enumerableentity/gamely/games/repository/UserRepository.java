package host.enumerableentity.gamely.games.repository;

import host.enumerableentity.gamely.games.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
