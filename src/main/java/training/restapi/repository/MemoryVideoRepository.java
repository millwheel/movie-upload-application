package training.restapi.repository;

import org.springframework.stereotype.Repository;
import training.restapi.domain.Video;

import java.util.*;
import java.util.stream.Stream;

@Repository
public class MemoryVideoRepository implements VideoRepository{

    private static Map<Long, Video> store = new HashMap();
    private static Long sequence = 0L;

    @Override
    public void make(Video video) {
        video.setId(sequence++);
        store.put(video.getId(), video);
    }

    @Override
    public Optional<Video> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Stream<Video> findByUsername(String userName) {
        return store.values().stream().filter(video -> video.getUserName().equals(userName));
    }

    public void clearStore() {
        store.clear();
    }
}
