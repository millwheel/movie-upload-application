package training.restapi.repository;

import org.junit.jupiter.api.AfterEach;
import training.restapi.repository.member.MemoryMemberRepository;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();


    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

}
