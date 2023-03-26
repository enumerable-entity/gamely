package host.enumerableentity.gamely.games.service;

import host.enumerableentity.gamely.games.dto.WalkthroughDTO;
import host.enumerableentity.gamely.games.mapper.WalkthroughMapper;
import host.enumerableentity.gamely.games.repository.WalkthroughRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalkthroughService {

    private final WalkthroughRepository walkthroughRepository;
    private final WalkthroughMapper walkthroughMapper;

    @Transactional
    public WalkthroughDTO addWalkthrough(WalkthroughDTO walkthroughDTO) {
        return walkthroughMapper.toDTO(walkthroughRepository.save(walkthroughMapper.toEntity(walkthroughDTO)));

    }

    public void removeWalkthrough(Long gameId, Long walkthroughId) {

    }
}
