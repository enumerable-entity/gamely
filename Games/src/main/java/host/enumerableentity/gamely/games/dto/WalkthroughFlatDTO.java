package host.enumerableentity.gamely.games.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record WalkthroughFlatDTO(
        VideoGameDTO game,
        GameCategoryDTO userCategory,
        List<WalkthroughDTO> walkthroughes) {
}
