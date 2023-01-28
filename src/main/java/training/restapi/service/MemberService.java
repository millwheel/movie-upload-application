package training.restapi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import training.restapi.domain.Member;
import training.restapi.form.JoinForm;
import training.restapi.repository.MemberRepository;
import java.util.Optional;

@Slf4j
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String join(JoinForm joinData){
        Member member = new Member();
        memberRepository.findByEmail(joinData.getName())
                .ifPresent(m -> {throw new IllegalArgumentException("이미 존재하는 회원입니다.");});
        member.setName(joinData.getName());
        member.setEmail(joinData.getEmail());
        member.setPassword(passwordEncoder.encode(joinData.getPassword()));
        memberRepository.make(member);
        return member.getPassword();
    }

    public Member login(String email, String password){
        Optional<Member> user = memberRepository.findByEmail(email);
        if(user.isEmpty()) {
            log.info("such email address doesn't exist");
            return null;
        }
        Member member = user.get();
        if(!member.getPassword().equals(password)){
            log.info("password wrong");
            return null;
        }
        return member;
    }
}
