package host.enumerableentity.gamely.games.mapper;

import host.enumerableentity.gamely.commons.dto.GamePlatformDTO;
import host.enumerableentity.gamely.games.entity.core.GamePlatformEntity;
import org.mapstruct.Mapper;

@Mapper
public interface GamePlatformMapper {
    GamePlatformDTO toDTO(GamePlatformEntity gamePlatformEntity);
}
