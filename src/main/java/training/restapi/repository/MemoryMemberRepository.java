package training.restapi.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import training.restapi.domain.Member;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public void make(Member member) {
        member.setId(sequence++);
        store.put(member.getId(), member);
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        return store.values().stream().filter(member -> member.getEmail().equals(email)).findAny();
    }

    public void clearStore() {
        store.clear();
    }
}
