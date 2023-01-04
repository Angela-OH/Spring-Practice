package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA: A 사용자가 10000원 주문
        statefulService1.order("userA", 10000);

        // ThreadB: B 사용자가 20000원 주문 (A가 주문을 하고 주문 금액을 조회하는 사이에 다른 코드가 끼어듬) >> problem!
        statefulService2.order("userB", 20000);

        // ThreadA: A 사용자가 주문 금액 조회
        int price = statefulService1.getPrice();
        System.out.println("price = " + price); // 20000원이 나옴
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}
