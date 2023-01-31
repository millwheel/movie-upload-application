package training.restapi.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import training.restapi.domain.Member;

import java.util.Optional;

@Slf4j
@Repository
@Transactional
public class JpaMemberRepository implements MemberRepository {

    private final EntityManager entityManager;
    @Autowired
    private MemberRepository memberRepository;

    public JpaMemberRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void make(Member member) {
        entityManager.persist(member);
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = entityManager.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        return null;
    }
}
