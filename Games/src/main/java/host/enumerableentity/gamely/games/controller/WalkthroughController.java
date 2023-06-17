package host.enumerableentity.gamely.games.controller;

import host.enumerableentity.gamely.commons.dto.WalkthroughDTO;
import host.enumerableentity.gamely.commons.dto.WalkthroughFlatDTO;
import host.enumerableentity.gamely.games.service.WalkthroughService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static host.enumerableentity.gamely.games.commons.ServiceConstants.API_PREFIX;

@Tag(name = "Walkthrough controller", description = "Controller for managing walkthrough's of user games")
@Slf4j
@RestController
@RequestMapping(API_PREFIX + "/games")
@RequiredArgsConstructor
public class WalkthroughController {

    private final WalkthroughService walkthroughService;

    @Operation(summary = "Add new walkthrough for game")
    @PostMapping("{gameId}/walkthroughes")
    public ResponseEntity<WalkthroughDTO> addWalkthrough(@RequestBody WalkthroughDTO walkthroughDTO) {
        return new ResponseEntity<>(walkthroughService.addWalkthrough(walkthroughDTO), HttpStatus.CREATED);
    }

    @Operation(summary = "Get all walkthrough for game")
    @GetMapping("{gameId}/walkthroughes")
    public ResponseEntity<List<WalkthroughDTO>> getAllWalkthroughesForGame(@PathVariable Long gameId) {
        return ResponseEntity.ok(walkthroughService.getAllWalkthroughesForGame(gameId));
    }

    @Operation(summary = "Get all walkthroughes")
    @GetMapping("walkthroughes")
    public ResponseEntity<List<WalkthroughFlatDTO>> getAllWalkthroughes() {
        return ResponseEntity.ok(walkthroughService.getAllWalkthroughes());
    }

    @Operation(summary = "Remove walkthrough for game")
    @DeleteMapping("{gameId}/walkthroughes/{walkthroughId}")
    public ResponseEntity<Void> removeWalkthroughForGame(@PathVariable Long gameId, @PathVariable Long walkthroughId) {
        walkthroughService.removeWalkthrough(walkthroughId);
        return ResponseEntity.noContent().build();
    }

}
