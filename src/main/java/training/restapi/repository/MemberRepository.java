package training.restapi.repository;

import training.restapi.domain.Member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long id);
    Member findByName(String name);
}
