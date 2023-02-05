package training.restapi.repository.video;

import org.springframework.data.jpa.repository.JpaRepository;
import training.restapi.domain.Video;

import java.util.List;
import java.util.stream.Stream;


public interface SpringDataJpaVideoRepository extends JpaRepository<Video, Long> {

    List<Video> findByUsername (String userName);
}
