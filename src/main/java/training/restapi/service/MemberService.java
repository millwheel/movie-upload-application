package training.restapi.service;

import training.restapi.domain.Member;
import training.restapi.repository.MemberRepository;

import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member){
        validatedDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    public void validatedDuplicateMember(Member member){
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {throw new IllegalArgumentException("이미 존재하는 회원입니다.");});
    }

    public Optional<Member> findMember(Long memberId){
        return memberRepository.findById(memberId);
    }
}
