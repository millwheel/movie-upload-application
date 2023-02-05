package training.restapi.repository.video;

import org.springframework.stereotype.Repository;
import training.restapi.domain.Video;

import java.util.*;
import java.util.stream.Stream;

@Repository
public class MemoryVideoRepository implements VideoRepository {

    private static Map<Long, Video> store = new HashMap();
    private static Long sequence = 0L;

    @Override
    public void save(Video video) {
        video.setId(sequence++);
        store.put(video.getId(), video);
    }

    @Override
    public Optional<Video> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Video> findByUsername(String userName) {
        return store.values().stream().filter(video -> video.getUsername().equals(userName)).toList();
    }

    public void clearStore() {
        store.clear();
    }
}
