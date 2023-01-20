package training.restapi.repository;

import training.restapi.domain.Member;

import java.util.Optional;

public interface MemberRepository {
    void save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
}