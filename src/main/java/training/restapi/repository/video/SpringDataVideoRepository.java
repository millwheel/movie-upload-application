package training.restapi.repository.video;

import training.restapi.domain.Video;
import training.restapi.repository.member.SpringDataJpaMemberRepository;
import training.restapi.repository.video.VideoRepository;

import java.util.Optional;
import java.util.stream.Stream;

public class SpringDataVideoRepository implements VideoRepository {

    private final SpringDataJpaMemberRepository repository;

    public SpringDataVideoRepository(SpringDataJpaMemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public void make(Video video) {

    }

    @Override
    public Optional<Video> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Stream<Video> findByUsername(String userName) {
        return null;
    }
}
