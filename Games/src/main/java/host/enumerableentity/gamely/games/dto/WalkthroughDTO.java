package host.enumerableentity.gamely.games.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record WalkthroughDTO(
        @JsonProperty(access = JsonProperty.Access.READ_ONLY) Long id,
        Long gameId,
        LocalDate date,
        Integer duration,
        Boolean pirated,
        String userLink,
        String userNotes,
        String externalUsernameCoop,
        UserDTO internalCoopUser,
        GamePlatformDTO platform) {
}
