package training.restapi.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;
import training.restapi.domain.Member;
import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);
}
