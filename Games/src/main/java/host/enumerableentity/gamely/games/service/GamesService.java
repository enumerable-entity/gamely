package host.enumerableentity.gamely.games.service;

import host.enumerableentity.gamely.commons.dto.VideoGameDTO;
import host.enumerableentity.gamely.games.mapper.VideoGameMapper;
import host.enumerableentity.gamely.games.repository.VideoGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GamesService {

    private final VideoGameRepository videoGameRepository;
    private final VideoGameMapper videoGameMapper;

    public Page<VideoGameDTO> getAllGames(Pageable paginationInfo) {
        return videoGameRepository.findAll(paginationInfo).map(videoGameMapper::toDTO);
    }
}
