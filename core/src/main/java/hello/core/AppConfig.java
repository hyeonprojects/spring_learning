package hello.core;

import hello.core.dicount.DiscountPolicy;
import hello.core.dicount.RateDicountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderserviceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository()); // 생성자를 통해서 들어간다고 해서 생성자 주입이라고 한다.
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderserviceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDicountPolicy();
    }
}

// 어플리케이션 설정 정보를 어노테이션 설정정보를 잡아주고, 각 설정정보에 bean을 적어주기로 함.
// AppConfig q버전