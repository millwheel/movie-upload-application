package training.restapi.repository;

import training.restapi.domain.Member;

import java.util.HashMap;
import java.util.Map;

public class memoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public void save(Member member) {
        member.setId(sequence++);
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long id) {
        return store.get(id);
    }

    @Override
    public Member findByName(String name) {
    }


}
