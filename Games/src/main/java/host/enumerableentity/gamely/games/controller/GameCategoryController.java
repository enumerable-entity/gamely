package host.enumerableentity.gamely.games.controller;

import host.enumerableentity.gamely.games.commons.DictionaryDTO;
import host.enumerableentity.gamely.commons.dto.GameCategoryDTO;
import host.enumerableentity.gamely.games.service.GameCategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static host.enumerableentity.gamely.games.commons.ServiceConstants.API_PREFIX;

@Tag(name = "Categories controller", description = "Controller for user categories management")
@Slf4j
@RestController
@RequestMapping(API_PREFIX + "/categories")
@RequiredArgsConstructor
public class GameCategoryController {

    private final GameCategoryService gameCategoryService;

    @Operation(summary = "Get all user categories")
    @GetMapping
    public ResponseEntity<Page<GameCategoryDTO>> getAllUserCategories(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "25") Integer size,
            @RequestParam(required = false, defaultValue = "title") String sort) {
        return ResponseEntity.ok(gameCategoryService.getAllUserCategories(PageRequest.of(page, size, Sort.by(sort))));
    }

    @Operation(summary = "Get all categories dictionary for selects")
    @GetMapping("dictionary")
    public ResponseEntity<List<DictionaryDTO>> getCategoriesDictionary() {
        return ResponseEntity.ok(gameCategoryService.getCategoriesDictionary());
    }

    @Operation(summary = "Add new userCategory")
    @PostMapping
    public ResponseEntity<GameCategoryDTO> addNewCategory(GameCategoryDTO gameCategoryDTO) {
        return ResponseEntity.ok(gameCategoryService.addNewCategory(gameCategoryDTO));
    }

    @Operation(summary = "Update userCategory")
    @PutMapping
    public ResponseEntity<GameCategoryDTO> updateCategory(GameCategoryDTO gameCategoryDTO) {
        return ResponseEntity.ok(gameCategoryService.addNewCategory(gameCategoryDTO));
    }
}
