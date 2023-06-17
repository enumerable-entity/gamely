package host.enumerableentity.gamely.games.mapper;

import host.enumerableentity.gamely.commons.dto.VideoGameDTO;
import host.enumerableentity.gamely.games.entity.core.VideoGameEntity;
import org.mapstruct.Mapper;

@Mapper(uses = {GamePlatformMapper.class})
public interface VideoGameMapper {
    VideoGameDTO toDTO(VideoGameEntity videoGameEntity);
}
