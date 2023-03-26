package host.enumerableentity.gamely.games.mapper;

import host.enumerableentity.gamely.games.dto.WalkthroughDTO;
import host.enumerableentity.gamely.games.entity.core.WalkthroughEntity;
import host.enumerableentity.gamely.games.mapper.decorator.WalkthroughMapperEntityDecorator;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
@DecoratedWith(WalkthroughMapperEntityDecorator.class)
public interface WalkthroughMapper {
    WalkthroughEntity toEntity(WalkthroughDTO walkthroughDTO);

    WalkthroughDTO toDTO(WalkthroughEntity walkthroughEntity);
}
