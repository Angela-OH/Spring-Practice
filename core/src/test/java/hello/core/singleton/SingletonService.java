package hello.core.singleton;

public class SingletonService {
    // 자기 자신을 private + static으로 가지고 있음 -> 하나만 존재 가능
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {} // 외부에서 호출 불가

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
