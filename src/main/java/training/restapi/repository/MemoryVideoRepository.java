package training.restapi.repository;

import training.restapi.domain.Video;

import java.util.*;

public class MemoryVideoRepository implements VideoRepository{

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
    public List<Video> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
