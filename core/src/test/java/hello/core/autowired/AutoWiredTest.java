package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutoWiredTest {

    @Test
    void AutoWiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {
        // Member와 관련된 스프링 빈은 등록되어 있지 않음
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) { // 아예 호출이 안 됨
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2) { // 호출은 됨, 값이 없는 경우 null 반환
            System.out.println("noBean1 = " + noBean2);
        }

        @Autowired
        public void setNoBean2(Optional<Member> noBean3) { // 호출은 됨, 값이 없는 경우 Optional.empty 반환
            System.out.println("noBean1 = " + noBean3);
        }
    }
}
