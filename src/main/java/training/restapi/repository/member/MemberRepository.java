package training.restapi.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import training.restapi.domain.Member;

import java.util.Optional;

public interface MemberRepository {
    void make(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByEmail(String email);
}
