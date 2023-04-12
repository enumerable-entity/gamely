package host.enumerableentity.gamely.games.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GameCategoryDTO(
        @JsonProperty(access = JsonProperty.Access.READ_ONLY) Long id,
        String title,
        String logoLink,
        String description) {
}
