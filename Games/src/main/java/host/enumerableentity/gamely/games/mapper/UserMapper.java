package host.enumerableentity.gamely.games.mapper;

import host.enumerableentity.gamely.commons.dto.UserSyncDto;
import host.enumerableentity.gamely.commons.dto.UserDTO;
import host.enumerableentity.gamely.games.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface UserMapper {
    UserDTO toDTO(UserEntity userEntity);

    List<UserDTO> toDTOs(List<UserEntity> userEntities);

    @Mapping(target = "categories", ignore = true)
    UserEntity fromSyncDto(UserSyncDto userSyncDto);
}
