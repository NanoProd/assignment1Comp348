package assignment1;

public interface Shape {
    //returns runtime/dynamic object type
    default String ShapeName() {
        return this.getClass().getSimpleName();
    }
    // return the Area of the shape
    public double ShapeArea();
    // return the Perimeter of the shape
    public double ShapePerimeter();
    
}
