package host.enumerableentity.gamely.games.mapper;

import host.enumerableentity.gamely.commons.dto.GameCategoryDTO;
import host.enumerableentity.gamely.games.entity.GameCategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface GameCategoryMapper {
    GameCategoryDTO toDTO(GameCategoryEntity gameCategoryEntity);


    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "isDeleted", ignore = true)
    GameCategoryEntity toEntity(GameCategoryDTO gameCategoryDTO);
}
