package lambda1;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        String abc = ",";
        Arrays.asList("a","b","c").forEach(e -> System.out.println(e));
        Arrays.asList("a","b","c").forEach(e -> System.out.println(e + abc));
        Arrays.asList("a","b","c").sort((e1,e2) -> e1.compareTo(e2));
    }
}
