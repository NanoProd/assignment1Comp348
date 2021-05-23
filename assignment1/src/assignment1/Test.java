package assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test {
    public static void main(String[]args) throws IOException{

        List<String> list = new ArrayList<>();
        List<Shape> objList = new ArrayList<>();

        //get rows
        Stream<String> shapes = Files.lines(Paths.get("Objects.txt"));

        shapes
            .map(x -> x.split(","))
            .filter(x -> x.length > 1)
            .forEach(x -> {
                if(x.length == 2){
                    Circle circ = new Circle(Double.parseDouble(x[1]));
                    objList.add(circ);
                } else {
                    if(x.length == 3){
                    Rectangle rect = new Rectangle(Double.parseDouble(x[1]), Double.parseDouble(x[2]));
                    objList.add(rect);
                    }
                }
            });

            objList.forEach(x -> System.out.println(x.ShapeName() + ", Area: " + x.ShapeArea()));









        /*


        list = shapes
            .flatMap(line -> Stream.of(line.split("Rectangle")))
            .flatMap(line -> Stream.of(line.split("Circle")))
            .collect(Collectors.toList());

        list.forEach(line -> {
            if(line.length() <4 && line.length() > 1){
                List<String> circles = Stream.of(line.split(","))
                            .map(elem -> {
                                if(elem.length() > 0){
                                    new String(elem);
                                }
                            })
                            .collect(Collectors.toList());
                circles.forEach(circle -> {
                    System.out.println(circle);
                    final Circle obj = new Circle(Double.parseDouble(circle));
                    objList.add(obj);
                    System.out.println(obj.GetRadius());
                });
            }
            
        });


        */
        shapes.close();
            

       //[Circle,\\d+,]|[Rectangle,\\d+,\\d+,]

       // list = shapes
       //             .filter(list.split("[^C|^R]"))
       //             .forEach(System.out::Println);
    }
        

  
}