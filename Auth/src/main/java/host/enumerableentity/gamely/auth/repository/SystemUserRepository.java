package host.enumerableentity.gamely.auth.repository;

import host.enumerableentity.gamely.auth.entity.SystemUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemUserRepository extends JpaRepository<SystemUserEntity, Long> {
    SystemUserEntity findByUsername(String username);
}
