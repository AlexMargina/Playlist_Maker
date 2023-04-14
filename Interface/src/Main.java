public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    @FunctionalInterface
    public interface SomeInterface {
        static void doSomething1() {  }
        void doSomething2();
    }
}