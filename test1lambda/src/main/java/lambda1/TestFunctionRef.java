package lambda1;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class TestFunctionRef {
    public static void main(String[] args) {
        Consumer<String> consumer = (x) -> System.out.println(x);

//        PrintStream out = System.out;

        Consumer<String> consumer1 = System.out::println;
        consumer.accept("456");
        consumer1.accept("456");

        Supplier<String> supplier = () -> "我是被返回的";
        System.out.println(supplier.get());
        System.out.println("=================");
        Supplier<String> supplier1 = new TestFunctionRef() :: get;
        System.out.println(supplier1.get());

        Oper

    }

    public String get(){
        return "我也是啊";
    }

    public static String com(){
        return "我也是啊";
    }

}
