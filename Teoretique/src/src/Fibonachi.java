public class Fibonachi {
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
            }
            return s;
        }
    }
}
