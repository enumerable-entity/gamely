package host.enumerableentity.gamely.games.mapper.decorator;

import host.enumerableentity.gamely.games.dto.WalkthroughDTO;
import host.enumerableentity.gamely.games.entity.SelectionKey;
import host.enumerableentity.gamely.games.entity.core.WalkthroughEntity;
import host.enumerableentity.gamely.games.mapper.WalkthroughMapper;
import host.enumerableentity.gamely.games.repository.GamePlatformRepository;
import host.enumerableentity.gamely.games.repository.GameSelectionRepository;
import host.enumerableentity.gamely.games.repository.UserRepository;
import host.enumerableentity.gamely.games.repository.VideoGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public abstract class WalkthroughMapperEntityDecorator implements WalkthroughMapper {

    @Autowired
    @Qualifier("delegate")
    private WalkthroughMapper delegate;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GamePlatformRepository gamePlatformRepository;
    @Autowired
    private GameSelectionRepository gameSelectionRepository;
    @Autowired
    private VideoGameRepository videoGameRepository;

    @Override
    public WalkthroughEntity toEntity(WalkthroughDTO walkthroughDTO) {
        WalkthroughEntity walkthroughEntity = delegate.toEntity(walkthroughDTO);

        SelectionKey selectionKey = new SelectionKey(
                userRepository.getReferenceById(-1L),
                videoGameRepository.getReferenceById(walkthroughDTO.gameId()));

        walkthroughEntity.setInternalUserCoop(userRepository.getReferenceById(walkthroughDTO.internalCoopUser().id()));
        walkthroughEntity.setPlatform(gamePlatformRepository.getReferenceById(walkthroughDTO.platform().id()));
        walkthroughEntity.setGameSelectionEntity(gameSelectionRepository.getReferenceById(selectionKey));
        return walkthroughEntity;
    }
}
