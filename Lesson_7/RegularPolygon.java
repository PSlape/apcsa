package Lesson_7;

public class RegularPolygon {
    protected int sideCount;
    protected double sideLength, rad, apo;
    
    public RegularPolygon() {
        this(3, 1);
    }
    public RegularPolygon(int numSides, double sideLength) {
        sideCount = numSides;
        this.sideLength = sideLength;
    }
    private void calcRad() {
        rad = sideLength / (2* Math.sin(Math.PI / sideCount));
    }
    private void calcApo() {
        apo = sideLength / (2 * Math.tan(Math.PI / this.sideCount));
    }
    public double getVertexAngle() {
        return ((double) (sideCount - 2) / (double) sideCount) * 180.0; 
    }
    public double getSideLength() {
        return sideLength;
    }
    public double getPerimeter() {
        return sideLength * sideCount;
    }
    public double getArea() {
        calcApo();
        if(getPerimeter() != 0)
            return (1.0/2.0) * apo * getPerimeter();
        else return (1.0/2.0) * sideCount * Math.pow(rad, 2) * Math.sin((2*Math.PI) / sideCount);
    }
    public double getNumSides() {
        return sideCount;
    }
    public double getApothem() {
        calcApo();
        return apo;
    }
    public double getRadius() {
        calcRad();
        return rad;
    }
}