package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) { // 외부에서 넣어주게 바꾸어줌 DI 디펜던시 인젝션
        this.memberRepository = memberRepository;
    }

    // 회원 가입
    public Long join(Member member){
        // 같은 이름이 있으면 중복 회원 x
//        Optional<Member> result = memberRepository.findByName(member.getName());
        validateDuplicateMember(member);

//        result.orElseGet()
//        result.ifPresent(m -> {
//            throw new IllegalAccessException("이미 존재하는 회원입니다.");
//        });

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    // 전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
