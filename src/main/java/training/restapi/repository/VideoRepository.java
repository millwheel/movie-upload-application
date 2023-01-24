package training.restapi.repository;

import training.restapi.domain.Member;
import training.restapi.domain.Video;

import java.util.List;
import java.util.Optional;

public interface VideoRepository {
    void enroll(Video video);
    Optional<Video> findById(Long id);
    Optional<Video> findByName(String name);
    Optional<Video> findByDate(String date);
    List<Video> findAll();
}
