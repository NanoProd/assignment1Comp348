package assignment1;

public class Rectangle implements Shape {
    //attributes
    private double width, length;

    //constructors
    public Rectangle(double width, double length){
        this.width = width;
        this.length = length;
    }
    

    public void SetWidth(double width) {
        this.width = width;
    }
    public double GetWidth() {
        return width;
    }

    public void SetLength(double length) {
        this.length  = length;
    }

    public double GetLength() {
        return length;
    }

    public String toString() {
        return ShapeName().getSimpleName()+ " with sides of  "+ width + " and "+ length + ".";
    }

    @Override
    public double ShapeArea() {
        return width*length;
    }

    @Override
    public double ShapePerimeter() {
        return 2 * width + 2 * length;
    }
    
    public static Rectangle Parse(String str) {
            String[] split  = str.split(",");
            return new Rectangle(Double.parseDouble(split[1]), Double.parseDouble(split[2]));
    }
}
