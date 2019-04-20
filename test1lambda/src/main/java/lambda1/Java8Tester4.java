package lambda1;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Java8Tester4 {

    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();    // 筛选苹果
        appleList.add(new Apple(1,Color.RED,123,"杭州"));
        appleList.add(new Apple(2,Color.BLUE,123,"杭州"));
        appleList.add(new Apple(3,Color.RED,34,"杭州"));
        appleList.add(new Apple(4,Color.RED,153,"杭州"));
        List<Apple> apples = filterApplesByAppleFilter(appleList,apple -> Color.RED.equals(apple.getColor()) && apple.getWeight() > 100  );
        apples.forEach(apple -> System.out.println(apple));



    }

    public <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> newList = new ArrayList<T>();
        for (final T t : list) {
            if (predicate.test(t)) {
                newList.add(t);
            }
        }
        return newList;
    }




    /**
     * 将筛选条件封装成接口
     *
     * @param apples
     * @param filter
     * @return
     */
    public static List<Apple> filterApplesByAppleFilter(List<Apple> apples, AppleFilter filter) {
         List<Apple> filterApples = new ArrayList<>();
         for (final Apple apple : apples) {
             if (filter.accept(apple)) {
                 filterApples.add(apple);
             }
         }
         return filterApples;
    }


}
