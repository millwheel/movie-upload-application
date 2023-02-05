package training.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import training.restapi.domain.Member;
import java.util.Optional;

public interface SpringDataJpaRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);
}
