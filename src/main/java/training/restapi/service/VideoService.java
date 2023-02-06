package training.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.restapi.domain.Video;
import training.restapi.repository.video.VideoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VideoService {
    private final VideoRepository videoRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public Optional<Video> findVideoById(Long id){
        return videoRepository.findById(id);
    }

    public List<Video> findVideos(String username){
        return videoRepository.findByUsername(username);
    }

    public void saveVideo(String name, String username){
        Video video = new Video();
        video.setName(name);
        video.setDate(LocalDateTime.now());
        video.setUsername(username);
        videoRepository.save(video);
    }

}
