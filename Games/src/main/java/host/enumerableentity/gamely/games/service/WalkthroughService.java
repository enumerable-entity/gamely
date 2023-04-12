package host.enumerableentity.gamely.games.service;

import host.enumerableentity.gamely.games.dto.WalkthroughDTO;
import host.enumerableentity.gamely.games.dto.WalkthroughFlatDTO;
import host.enumerableentity.gamely.games.entity.GameSelectionEntity;
import host.enumerableentity.gamely.games.entity.core.WalkthroughEntity;
import host.enumerableentity.gamely.games.mapper.WalkthroughMapper;
import host.enumerableentity.gamely.games.repository.WalkthroughRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WalkthroughService {

    private final WalkthroughRepository walkthroughRepository;
    private final SelectionService selectionService;
    private final WalkthroughMapper walkthroughMapper;

    @Transactional
    public WalkthroughDTO addWalkthrough(WalkthroughDTO walkthroughDTO) {
        return walkthroughMapper.toDTO(walkthroughRepository.save(walkthroughMapper.toEntity(walkthroughDTO)));

    }

    @Transactional
    public void removeWalkthrough(Long walkthroughId) {
        Optional<WalkthroughEntity> walkthrough = walkthroughRepository.findById(walkthroughId);
        walkthrough.ifPresent(walkthroughEntity -> walkthroughEntity.setEnabled(false));
    }

    public List<WalkthroughDTO> getAllWalkthroughesForGame(Long gameId) {
        return walkthroughMapper.toDTOs(selectionService.getAllWalkthroughesForGame(gameId));
    }

    @Transactional
    public List<WalkthroughFlatDTO> getAllWalkthroughes() {
        return selectionService.getAllSelections().stream()
                .flatMap(selection -> selection.getCompletions().stream())
                .map(walkthroughMapper::toFlatDTO)
                .toList();
    }
}
