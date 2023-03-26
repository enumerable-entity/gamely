package host.enumerableentity.gamely.games.controller;

import host.enumerableentity.gamely.games.dto.WalkthroughDTO;
import host.enumerableentity.gamely.games.service.WalkthroughService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Walkthrough controller", description = "Controller for managing walkthrough's of user games")
@Slf4j
@RestController
@RequestMapping("games/{gameId}/walkthrough")
@RequiredArgsConstructor
public class WalkthroughController {

    private final WalkthroughService walkthroughService;

    @Operation(summary = "Add new walkthrough for game.")
    @PostMapping
    public ResponseEntity<WalkthroughDTO> addWalkthrough(@RequestBody WalkthroughDTO walkthroughDTO) {
        return new ResponseEntity<>(walkthroughService.addWalkthrough(walkthroughDTO), HttpStatus.CREATED);
    }

    @Operation(summary = "Remove game from user selection")
    @DeleteMapping
    public ResponseEntity<Void> removeGameFromSelection(@RequestParam Long gameId, @RequestParam Long walkthroughId) {
        walkthroughService.removeWalkthrough(gameId, walkthroughId);
        return ResponseEntity.noContent().build();
    }

}
