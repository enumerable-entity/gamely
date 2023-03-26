package host.enumerableentity.gamely.games.dto;

import java.time.LocalDate;

public record WalkthroughDTO(Long id,
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
