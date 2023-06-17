package host.enumerableentity.gamely.games.mapper;

import host.enumerableentity.gamely.commons.dto.WalkthroughDTO;
import host.enumerableentity.gamely.commons.dto.WalkthroughFlatDTO;
import host.enumerableentity.gamely.games.entity.core.WalkthroughEntity;
import host.enumerableentity.gamely.games.mapper.decorator.WalkthroughMapperEntityDecorator;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {UserMapper.class, VideoGameMapper.class, GamePlatformMapper.class, GameCategoryMapper.class})
@DecoratedWith(WalkthroughMapperEntityDecorator.class)
public interface WalkthroughMapper {

    @Mapping(target = "enabled", ignore = true)
    @Mapping(target = "gameSelection", ignore = true)
    @Mapping(target = "internalUserCoop", ignore = true)
    WalkthroughEntity toEntity(WalkthroughDTO walkthroughDTO);

    @Mapping(target = "internalCoopUser", source = "internalUserCoop")
    @Mapping(target = "gameId", source = "walkthroughEntity.gameSelection.selectionKey.game.id")
    WalkthroughDTO toDTO(WalkthroughEntity walkthroughEntity);

    List<WalkthroughDTO> toDTOs(Set<WalkthroughEntity> allWalkthroughes);

    @Mapping(target = "userCategory", source = "walkthroughEntity.gameSelection.category")
    @Mapping(target = "walkthroughes", source = "walkthroughEntity.gameSelection.completions")
    @Mapping(target = "game", source = "walkthroughEntity.gameSelection.selectionKey.game")
    WalkthroughFlatDTO toFlatDTO(WalkthroughEntity walkthroughEntity);
}
