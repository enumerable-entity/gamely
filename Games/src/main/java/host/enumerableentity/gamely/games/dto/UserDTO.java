package host.enumerableentity.gamely.games.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserDTO(
        Long id,
        @JsonProperty(access = JsonProperty.Access.READ_ONLY) String username) {
}
