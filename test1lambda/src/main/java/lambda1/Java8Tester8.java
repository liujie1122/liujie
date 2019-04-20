package lambda1;

import java.util.Comparator;
import java.util.function.Consumer;

public class Java8Tester8 {
    public static void main(String[] args) {
        int num =0;
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我是java7"+num);
            }
        };
        r1.run();

        System.out.println("==============");
        Runnable r2 = () -> System.out.println("我是java8"+num);
        r2.run();

        System.out.println("==============");
        Consumer consumer = (x) -> System.out.println("我是:"+x);
        consumer.accept(9);

        System.out.println("==============");
        Consumer consumer1 = x -> System.out.println("我是:"+x);
        consumer1.accept(10);

        System.out.println("==============");
        Comparator<Integer> comparator = (x,y) -> {
            System.out.println("x="+x);
            return Integer.compare(x,y);
//            return Integer.compare(x,y);
        };
        System.out.println(comparator.compare(14,11));

        System.out.println("==============");
        Comparator<Integer> comparator1 = (x,y) -> Integer.compare(x,y);
//            return Integer.compare(x,y);
        System.out.println(comparator1.compare(11,15));

    }
}
