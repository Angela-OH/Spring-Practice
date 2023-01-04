package hello.core.singleton;

public class StatefulService {
    private int price; // 상태를 유지하는 필드

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        this.price = price; // problem!
    }

    public int statelessOrder(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        return price; // ex. 지역변수로 선언해서 해결
    }
    public int getPrice() {
        return price;
    }
}
