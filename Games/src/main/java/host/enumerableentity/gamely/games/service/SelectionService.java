package host.enumerableentity.gamely.games.service;

import host.enumerableentity.gamely.games.entity.GameSelectionEntity;
import host.enumerableentity.gamely.games.entity.SelectionKey;
import host.enumerableentity.gamely.games.entity.core.WalkthroughEntity;
import host.enumerableentity.gamely.games.exception.RestException;
import host.enumerableentity.gamely.games.repository.GameCategoryRepository;
import host.enumerableentity.gamely.games.repository.GameSelectionRepository;
import host.enumerableentity.gamely.games.repository.UserRepository;
import host.enumerableentity.gamely.games.repository.VideoGameRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SelectionService {

    private final GameSelectionRepository gameSelectionRepository;
    private final GameCategoryRepository gameCategoryRepository;
    private final UserRepository userRepository;
    private final VideoGameRepository videoGameRepository;

    @Transactional
    public void addGameToCategory(Long gameId, Long categoryId) {
        SelectionKey selectionKey = new SelectionKey(
                userRepository.getReferenceById(-1L),
                videoGameRepository.getReferenceById(gameId));

        GameSelectionEntity newUserSelection = GameSelectionEntity.builder()
                .selectionKey(selectionKey)
                .category(categoryId == null ? null : gameCategoryRepository.getReferenceById(categoryId))
                .build();
        gameSelectionRepository.save(newUserSelection);
    }

    public void removeGameFromCategory(Long gameId) {
        SelectionKey selectionKey = new SelectionKey(
                userRepository.getReferenceById(-1L),
                videoGameRepository.getReferenceById(gameId));
        gameSelectionRepository.deleteById(selectionKey);
    }

    public Set<WalkthroughEntity> getAllWalkthroughesForGame(Long gameId) {
        SelectionKey selectionKey = new SelectionKey(
                userRepository.getReferenceById(302L),
                videoGameRepository.getReferenceById(gameId));
        return gameSelectionRepository.findById(selectionKey)
                .map(GameSelectionEntity::getCompletions)
                .orElseThrow(() -> new RestException("Walkthroughes not found"));
    }

    public List<GameSelectionEntity> getAllSelections(){
        return gameSelectionRepository.findAllBySelectionKeyUserId(-1L);
    }
}
