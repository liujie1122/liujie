package lambda1;

public class Java8Tester2 {
    public static void main(String[] args) {
        Java8Tester2 tester = new Java8Tester2();

        MathOperation add = (a,b) -> a + b;

        MathOperation sub = (int a,int b) -> a - b;

        MathOperation mul = (a,b) -> {return a*b;};

        MathOperation div = (a,b) ->  a/b;

        System.out.println("5 + 3 = "+tester.operate(5,3,add));
        System.out.println("5 - 3 = "+tester.operate(5,3,sub));
        System.out.println("5 * 3 = "+tester.operate(5,3,mul));
        System.out.println("5 / 3 = "+tester.operate(5,3,div));


        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");


    }


    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }

}
