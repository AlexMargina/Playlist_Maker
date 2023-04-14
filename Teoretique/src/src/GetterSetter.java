public class GetterSetter {
    static double radius = 1.0;
    public GetterSetter (double radius) {
        this.radius = radius;
    }

    public GetterSetter() {
         this.radius = 2.0;
    }

    public double area () {
        double pi = 3.1415926;
        return radius*radius* pi;
    }
}
