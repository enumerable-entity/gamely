package host.enumerableentity.gamely.auth.mapper;


import host.enumerableentity.gamely.auth.entity.SystemUserEntity;
import host.enumerableentity.gamely.commons.dto.UserSyncDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

   public UserSyncDto toSyncDto(SystemUserEntity user) {
        return new UserSyncDto(user.getId(), user.getUsername(), user.isEnabled());
    }

}
