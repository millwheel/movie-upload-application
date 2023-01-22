package training.restapi.repository;

import training.restapi.domain.Member;
import training.restapi.domain.Video;

import java.util.List;
import java.util.Optional;

public interface VideoRepository {
    void enroll(Video video);
    Optional<Video> findById(Long id);
    List<Video> findAll();
}
