package training.restapi.repository.video;

import org.springframework.data.jpa.repository.JpaRepository;
import training.restapi.domain.Video;

public interface SpringDataJpaVideoRepository extends JpaRepository<Video, Long> {

}
