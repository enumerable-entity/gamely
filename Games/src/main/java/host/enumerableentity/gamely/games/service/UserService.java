package host.enumerableentity.gamely.games.service;

import host.enumerableentity.gamely.commons.dto.UserDTO;
import host.enumerableentity.gamely.games.entity.UserEntity;
import host.enumerableentity.gamely.games.mapper.UserMapper;
import host.enumerableentity.gamely.games.repository.UserRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static host.enumerableentity.gamely.games.entity.UserEntity.Fields.username;

@Service
@RequiredArgsConstructor
public class UserService {

    private final EntityManager entityManager;
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<UserDTO> findUserByUsername(String usernameS) {
        SearchSession searchSession = Search.session(entityManager);

        SearchResult<UserEntity> result = searchSession
                .search(UserEntity.class)
                .where(f -> f.match()
                        .field(username)
                        .matching(usernameS)
                        .fuzzy(2))
                .fetch(3);
        return userMapper.toDTOs(result.hits());
    }

    public Long getIdByUsername(String username) {
        return userRepository.getIdByUserName(username);
    }

}
