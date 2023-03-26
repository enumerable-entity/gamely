package host.enumerableentity.gamely.games.mapper;

import host.enumerableentity.gamely.games.dto.UserDTO;
import host.enumerableentity.gamely.games.kafka.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {
    UserDTO toDTO(UserEntity userEntity);
}
