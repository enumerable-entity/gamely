package host.enumerableentity.gamely.auth.dto;

import host.enumerableentity.gamely.auth.commons.Role;

public record FullInfoUserDTO(

        Long id,
        String username,
        String email,
        String firstName,
        String lastName,
        String avatarLink,
        Role role
) {
}
