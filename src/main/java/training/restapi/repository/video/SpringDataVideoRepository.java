package training.restapi.repository.video;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import training.restapi.domain.Video;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Slf4j
@Repository
@Primary
@Transactional
public class SpringDataVideoRepository implements VideoRepository {

    private final SpringDataJpaVideoRepository repository;

    public SpringDataVideoRepository(SpringDataJpaVideoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void make(Video video) {
        repository.save(video);
    }

    @Override
    public Optional<Video> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Video> findByUsername(String userName) {
        return repository.findByUsername(userName);
    }
}
