package host.enumerableentity.gamely.games.controller;

import host.enumerableentity.gamely.games.dto.VideoGameDTO;
import host.enumerableentity.gamely.games.service.GamesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Public games controller", description = "Controller for games")
@Slf4j
@RestController
@RequestMapping("games")
@RequiredArgsConstructor
public class GamesController {

    private final GamesService gamesService;

    @Operation(summary = "Get all public available games")
    @GetMapping
    public ResponseEntity<Page<VideoGameDTO>> getAllGames(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "25") Integer size,
            @RequestParam(required = false, defaultValue = "title") String sort) {
        return ResponseEntity.ok(gamesService.getAllGames(PageRequest.of(page, size, Sort.by(sort))));
    }
}