package host.enumerableentity.gamely.games.service;

import host.enumerableentity.gamely.games.commons.DictionaryDTO;
import host.enumerableentity.gamely.games.repository.GamePlatformRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GamePlatformService {

    private final GamePlatformRepository gamePlatformRepository;

    public List<DictionaryDTO> getPlatformDict() {
        return gamePlatformRepository.findAll().stream()
                .map(gamePlatform -> new DictionaryDTO(gamePlatform.getId(), gamePlatform.getTitle()))
                .toList();
    }
}
