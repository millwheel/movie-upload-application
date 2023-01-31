package training.restapi.repository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import training.restapi.domain.Member;

import java.util.Optional;

@Slf4j
@Repository
@Primary
@Transactional
public class SpringDataJpaRepository implements MemberRepository {

    private final SpringDataJpaMemberRepository repository;

    public SpringDataJpaRepository(SpringDataJpaMemberRepository springDataJpaMemberRepository) {
        this.repository = springDataJpaMemberRepository;
    }

    @Override
    public void make(Member member) {
        repository.save(member);
    }

    @Override
    public Optional<Member> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
