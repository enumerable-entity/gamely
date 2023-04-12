package host.enumerableentity.gamely.games.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.Set;

public record VideoGameDTO(
        @JsonProperty(access = JsonProperty.Access.READ_ONLY) Long id,
        String title,
        LocalDate releaseDate,
        String logoLink,
        String description,
        String wikiLink,
        Set<GamePlatformDTO> platforms) {
}
