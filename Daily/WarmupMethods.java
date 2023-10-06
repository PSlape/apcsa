package Daily;


/**
 * Write a description of class WarmupMethods here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WarmupMethods {
    private double a, b;
    
    public WarmupMethods() {
        a = 0;
        b = 0;
    }
    public WarmupMethods(double a, double b) {
        this.a = a;
        this.b = b;
    }
    double product() {
        return a * b;
    }
    double getA() {
        return a;
    }
    double getB() {
        return b;
    }
}
