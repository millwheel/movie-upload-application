package training.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.restapi.domain.Member;
import training.restapi.repository.MemberRepository;

import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member){
        validatedDuplicateMember(member);
        memberRepository.make(member);
        return member.getId();
    }

    public void validatedDuplicateMember(Member member){
        memberRepository.findByEmail(member.getName())
                .ifPresent(m -> {throw new IllegalArgumentException("이미 존재하는 회원입니다.");});
    }

    public boolean login(String email, String password){
        Optional<Member> user = memberRepository.findByEmail(email);
        if(!user.isPresent()) {
            return false;
        }

        if(memberRepository.matchPassword(user) != password){
            return false;
        }
        return true;
    }
}
