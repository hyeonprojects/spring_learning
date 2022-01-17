package hello.core;

import hello.core.dicount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderserviceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository()); // 생성자를 통해서 들어간다고 해서 생성자 주입이라고 한다.
    }

    public OrderService orderService() {
        return new OrderserviceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
