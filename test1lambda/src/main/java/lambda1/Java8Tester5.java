package lambda1;

import java.util.Comparator;

public class Java8Tester5 {
    public static void main(String[] args) {

        final int num = 1;
        Converter<Integer, String> s = (param) -> System.out.println(param + num);
        s.convert(2);

        Integer first = 10;
        Comparator<String> comparator = (first1,second) -> Integer.compare( first1.length(),second.length());

//        String first = "";
//        Comparator<String> comparator = (first, second) -> Integer.compare(first.length(), second.length());

    }

    public interface Converter<T1, T2> {
        void convert(int i);
    }

}
