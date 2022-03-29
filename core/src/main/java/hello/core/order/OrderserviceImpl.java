package hello.core.order;

import hello.core.dicount.DiscountPolicy;
import hello.core.dicount.FixDiscountPolicy;
import hello.core.dicount.RateDicountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderserviceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy; // 이렇게 되면 인터페이스를 의존하게 된다. 그러나 구현한게 없다



//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }

    public OrderserviceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice); // 나는 잘 모르지만 할인은 니가해줘. 단일 책임의 원칙을 잘 지킨 사례

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // Test 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
