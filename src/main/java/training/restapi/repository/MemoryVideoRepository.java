package training.restapi.repository;

import org.springframework.stereotype.Repository;
import training.restapi.domain.Video;

import java.util.*;

@Repository
public class MemoryVideoRepository implements VideoRepository{

    private static Map<Long, Video> store = new HashMap();
    private static Long sequence = 0L;

    @Override
    public void enroll(Video video) {
        video.setId(sequence++);
        store.put(video.getId(), video);
    }

    @Override
    public Optional<Video> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Video> findByName(String name) {
        return store.values().stream().filter(video -> video.getName().equals(name)).findAny();
    }

    @Override
    public Optional<Video> findByDate(String date) {
        return Optional.empty();
    }

    @Override
    public List<Video> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
