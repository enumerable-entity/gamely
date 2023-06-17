package host.enumerableentity.gamely.games.repository;

import host.enumerableentity.gamely.games.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("SELECT u.id FROM UserEntity u WHERE u.username = :username")
    Long getIdByUserName(String username);
}
