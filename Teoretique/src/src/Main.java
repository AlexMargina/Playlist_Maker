public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        GetterSetter areas = new GetterSetter();
        System.out.println(areas.area());
        System.out.println("***********");
        GetterSetter areas1 = new GetterSetter(3);
        System.out.println(areas1.area());
        System.out.println("***********");
        areas.radius = 10.0;
        System.out.println(areas.area());

        System.out.println(fib(12));

    }
    public static int fib (int n) {
        if (n<=2) {return 1;}
        else {
            int s=0;
            int f1=1;
            int f2=1;
            for (int i=2; i<n; i++) {
                s = f1 + f2;
                f1=f2;
                f2=s;
                //System.out.println("месяц: " +i + "  F1-" + f1 + "  F2-" +f2 + "  s: " + s );
            }
            return s;
        }
    }
}
