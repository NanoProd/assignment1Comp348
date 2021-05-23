package assignment1;

public class Circle implements Shape{
    //returns runtime/dynamic object type

    private double radius;

    //constructors
    public Circle(double radius){
        this.radius = radius;}
    

    public void SetRadius(double radius) {
        this.radius = radius;
    }

    public double GetRadius() {
        return radius;
    }

    public String toString(){
        return ShapeName().getSimpleName().toUpperCase() + " with radius " + radius + ".";
    }

    @Override
    public double ShapeArea() {
        return radius*radius*3.14159;
    }

    @Override
    public double ShapePerimeter() {
        return 2*radius*3.14159;
    }

    public static Circle Parse(String str) {
        String[] split  = str.split(",");
        return new Circle(Double.parseDouble(split[1]));
    }

}