package host.enumerableentity.gamely.games.dto;

import java.time.LocalDate;
import java.util.Set;

public record VideoGameDTO(Long id, String title, LocalDate releaseDate, String logoLink, String description,
                           String wikiLink, Set<GamePlatformDTO> platforms) {
}
