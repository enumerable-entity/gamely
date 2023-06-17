package host.enumerableentity.gamely.games.controller;

import host.enumerableentity.gamely.commons.dto.UserDTO;
import host.enumerableentity.gamely.games.commons.DictionaryDTO;
import host.enumerableentity.gamely.games.service.GamePlatformService;
import host.enumerableentity.gamely.games.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static host.enumerableentity.gamely.games.commons.ServiceConstants.API_PREFIX;

@Tag(name = "Public games controller", description = "Controller for games")
@Slf4j
@RestController
@RequestMapping(API_PREFIX + "/dictionary/users")
@RequiredArgsConstructor
public class DictionaryController {
    private final UserService userService;
    private final GamePlatformService gamePlatformService;

    @Operation(summary = "Search for users")
    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsersDict(@RequestParam String search) {
        return ResponseEntity.ok(userService.findUserByUsername(search));
    }

    @Operation(summary = "Search for users")
    @GetMapping
    public ResponseEntity<List<DictionaryDTO>> getPlatformDict() {
        return ResponseEntity.ok(gamePlatformService.getPlatformDict());
    }
}
