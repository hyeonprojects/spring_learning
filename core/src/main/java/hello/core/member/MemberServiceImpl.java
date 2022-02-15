package hello.core.member;

import hello.core.dicount.DiscountPolicy;
import org.springframework.core.annotation.Order;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository; // 당형성에 의해서 이 인스턴스에

    public MemberServiceImpl(MemberRepository memberRepository) { // 생성자를 만들어 놓고
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도

}
