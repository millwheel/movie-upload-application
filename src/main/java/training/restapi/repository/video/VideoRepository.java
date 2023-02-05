package training.restapi.repository.video;

import training.restapi.domain.Video;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface VideoRepository {
    void save(Video video);
    Optional<Video> findById(Long id);
    List<Video> findByUsername(String userName);
}
