package host.enumerableentity.gamely.games.service;

import host.enumerableentity.gamely.games.commons.DictionaryDTO;
import host.enumerableentity.gamely.commons.dto.GameCategoryDTO;
import host.enumerableentity.gamely.games.entity.GameCategoryEntity;
import host.enumerableentity.gamely.games.mapper.GameCategoryMapper;
import host.enumerableentity.gamely.games.repository.GameCategoryRepository;
import host.enumerableentity.gamely.games.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameCategoryService {

    private final GameCategoryRepository gameCategoryRepository;
    private final GameCategoryMapper gameCategoryMapper;
    private final UserRepository userRepository;

    public Page<GameCategoryDTO> getAllUserCategories(PageRequest paginationInfo) {
        return gameCategoryRepository.findAllByUserId(-1L, paginationInfo).map(gameCategoryMapper::toDTO);
    }

    public List<DictionaryDTO> getCategoriesDictionary() {
        return gameCategoryRepository.getDictionary();
    }

    public GameCategoryDTO addNewCategory(GameCategoryDTO gameCategoryDTO) {
        GameCategoryEntity newEntity = gameCategoryMapper.toEntity(gameCategoryDTO);
        newEntity.setUser(userRepository.getReferenceById(-1L));
        GameCategoryEntity savedEntity = gameCategoryRepository.save(newEntity);
        return gameCategoryMapper.toDTO(savedEntity);
    }
}
