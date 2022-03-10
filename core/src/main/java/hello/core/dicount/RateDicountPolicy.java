package hello.core.dicount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDicountPolicy implements DiscountPolicy {

    private int discountCount = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountCount / 100;
        } else {
            return 0;
        }
    }
}
