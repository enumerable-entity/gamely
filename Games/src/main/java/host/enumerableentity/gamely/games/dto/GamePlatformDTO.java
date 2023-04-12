package host.enumerableentity.gamely.games.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GamePlatformDTO(
        Long id,
        @JsonProperty(access = JsonProperty.Access.READ_ONLY) String title,
        @JsonProperty(access = JsonProperty.Access.READ_ONLY) String logoLink,
        @JsonProperty(access = JsonProperty.Access.READ_ONLY) String holder) {
}
