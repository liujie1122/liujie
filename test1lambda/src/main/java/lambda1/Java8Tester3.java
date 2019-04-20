package lambda1;

public class Java8Tester3 {

    final static String salutation = "Hello! ";

    public static void main(String[] args) {
        GreetingService gs = message -> System.out.println(salutation + message);
        gs.sayMessage("message");
    }

    interface GreetingService {
        void sayMessage(String message);
    }

}
