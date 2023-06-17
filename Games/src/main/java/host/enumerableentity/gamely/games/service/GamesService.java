package host.enumerableentity.gamely.games.service;

import host.enumerableentity.gamely.commons.dto.VideoGameDTO;
import host.enumerableentity.gamely.games.entity.core.VideoGameEntity;
import host.enumerableentity.gamely.games.mapper.VideoGameMapper;
import host.enumerableentity.gamely.games.repository.VideoGameRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.errors.ApiException;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static host.enumerableentity.gamely.games.entity.core.VideoGameEntity.Fields.title;

@Service
@RequiredArgsConstructor
public class GamesService {

    private final VideoGameRepository videoGameRepository;
    private final VideoGameMapper videoGameMapper;
    private final EntityManager entityManager;

    @Transactional(readOnly = true)
    public Page<VideoGameDTO> getAllGames(Pageable paginationInfo, String search) {
        if (search == null) {
            return videoGameRepository.findAll(paginationInfo).map(videoGameMapper::toDTO);
        } else {
            return search(search, paginationInfo);
        }
    }

    public Page<VideoGameDTO> search(String query, Pageable pageable) {
        SearchSession searchSession = Search.session(entityManager);
        org.apache.lucene.search.Sort sort = new Sort(new SortField(pageable.getSort().toString(), SortField.FIELD_SCORE.getType(), true));
        SearchResult<VideoGameEntity> result = searchSession
                .search(VideoGameEntity.class)
                .where(f -> f.match()
                        .field(title)
                        .matching(query)
                        .fuzzy(2))
                .fetch(pageable.getPageNumber() * pageable.getPageSize(), pageable.getPageSize());
        return new PageImpl<>(videoGameMapper.toDTOs(result.hits()), pageable, result.total().hitCount());
    }

    @Transactional(readOnly = true)
    public VideoGameDTO getById(Long id) {
        return videoGameRepository.findById(id)
                .map(videoGameMapper::toDTO)
                .orElseThrow(() -> new ApiException("Game not found"));
    }
}
