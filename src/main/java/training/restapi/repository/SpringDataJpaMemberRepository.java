package training.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import training.restapi.domain.Member;

import java.util.List;
import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);
}
