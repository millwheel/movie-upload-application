package training.restapi.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import training.restapi.domain.Member;
import training.restapi.service.MemberService;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    public void joinAndFindTest(){
        Member member = new Member();
        member.setName("minsu");
        Long id = memberService.join(member);

        Member memberReturn = memberService.findMember(id).get();

        assertThat(memberReturn.getName()).isEqualTo(member.getName());
    }



}
