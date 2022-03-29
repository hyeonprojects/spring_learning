package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowireTest {

    @Test
    void AUtowiredOption(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) { //호출 자체가 안됨
            // 스프링이 관리하지 않는 메버임
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean1) { //호출은 되는데 null이 됨
            // 스프링이 관리하지 않는 메버임
            System.out.println("noBean2 = " + noBean1);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3) { //
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
