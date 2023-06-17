package host.enumerableentity.gamely.games.controller;

import host.enumerableentity.gamely.commons.dto.VideoGameDTO;
import host.enumerableentity.gamely.games.service.GamesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static host.enumerableentity.gamely.games.commons.ServiceConstants.API_PREFIX;

@Tag(name = "Public games controller", description = "Controller for games")
@Slf4j
@RestController
@RequestMapping(API_PREFIX + "/games")
@RequiredArgsConstructor
public class GamesController {

    private final GamesService gamesService;

    @Operation(summary = "Get all public available games")
    @GetMapping
    public ResponseEntity<Page<VideoGameDTO>> getAllGames(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "5") Integer size,
            @RequestParam(required = false, defaultValue = "title") String sort,
            @RequestParam(required = false) String search) {
        log.debug("Get all games with page: {}, size: {}, sort: {}", page, size, sort);
        return ResponseEntity.ok(gamesService.getAllGames(PageRequest.of(page, size, Sort.by(sort)), search));
    }


    @Operation(summary = "Get all public available games")
    @GetMapping("/{id}")
    public ResponseEntity<VideoGameDTO> getById(@PathVariable Long id) {
        log.debug("Get video game by id: {}", id);
        return ResponseEntity.ok(gamesService.getById(id));
    }

}
