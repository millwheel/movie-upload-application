package training.restapi.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import training.restapi.domain.Member;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();


    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("kim");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("park");
        repository.save(member2);

        repository.findByName("kim");
        System.out.println(member1.getName());
    }
}
