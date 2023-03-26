package host.enumerableentity.gamely.games.controller;

import host.enumerableentity.gamely.games.service.SelectionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Selection controller", description = "Controller for making user selections of games")
@Slf4j
@RestController
@RequestMapping("selection")
@RequiredArgsConstructor
public class UserSelectionController {

    private final SelectionService selectionService;

    @Operation(summary = "Add game to user category. If category is not specified, game will be added to 'Default' category.")
    @PostMapping
    public ResponseEntity<Void> addGameToCategory(@RequestParam Long gameId, @RequestParam(required = false) Long categoryId) {
        selectionService.addGameToCategory(gameId, categoryId);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Remove game from user selection")
    @DeleteMapping
    public ResponseEntity<Void> removeGameFromSelection(@RequestParam Long gameId) {
        selectionService.removeGameFromSelection(gameId);
        return ResponseEntity.noContent().build();
    }

}
