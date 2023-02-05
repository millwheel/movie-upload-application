package training.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.restapi.repository.video.VideoRepository;

@Service
public class VideoService {
    private final VideoRepository videoRepository;

    @Autowired
    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public Object[] findVideoForUser(String username){
        Object[] videoList = videoRepository.findByUsername(username).toArray();
        return videoList;
    }

}
