package hello.core.order;

import hello.core.dicount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderserviceImplTest {

    @Test
    void createOrder() {
        MemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));

        OrderserviceImpl orderservice = new OrderserviceImpl(memberRepository, new FixDiscountPolicy());
        Order order = orderservice.createOrder(1L, "itemA", 10000);
        orderservice.createOrder(1L, "itemA", 10000);
    }
}