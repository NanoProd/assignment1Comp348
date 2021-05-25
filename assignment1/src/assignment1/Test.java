package assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Scanner;
import java.util.stream.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test {
    public static void main(String[]args) throws IOException{

        //get file name from user
        Scanner is = new Scanner(System.in);
        System.out.println("What is the file name?");
        String fileName = is.nextLine();
        is.close();
        List<Shape> objList = new ArrayList<>();

        //get rows
        Stream<String> shapes = null; 
        try{
             shapes = Files.lines(Paths.get(fileName));
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch(IOException e){
            e.printStackTrace();
        }

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

            System.out.println("-----------------------------");
            System.out.println("Original Object list: \n");
            objList.forEach(x -> System.out.println(x.ShapeName() + ", Area: " + x.ShapeArea()));
            System.out.println("-----------------------------");
            System.out.println("Objects sorted by name, then area: \n");
            Collections.sort(objList, new Comparator<Shape>(){
                @Override
                public int compare(Shape lhs, Shape rhs){
                    if(lhs.ShapeName().equals(rhs.ShapeName())){
                        return (int) (lhs.ShapeArea() - rhs.ShapeArea());
                    } else {
                        return lhs.ShapeName().compareTo(rhs.ShapeName());
                    }
                }
            });
            objList.forEach(x -> System.out.println(x.ShapeName() + ", Area: " + x.ShapeArea()));
            System.out.println("-----------------------------");
            System.out.println("Objects sorted by perimeter only:\n");
            Collections.sort(objList, new Comparator<Shape>(){
                @Override
                public int compare(Shape lhs, Shape rhs){
                    return (int) (lhs.ShapePerimeter() - rhs.ShapePerimeter());
                }
            });
            objList.forEach(x -> System.out.println(x.ShapeName() + ", Perimeter: " + x.ShapePerimeter()));
            System.out.println("-----------------------------");
            System.out.println("Rectangle averages statistics: \n");
            DoubleSummaryStatistics stats = objList.stream()
                                            .filter(shape -> shape.ShapeName().equals("Rectangle"))
                                            .mapToDouble(Shape::ShapeArea)
                                            .summaryStatistics();
            double avg = stats.getAverage();
            double min = stats.getMin();
            double max = stats.getMax();
            double sum = stats.getSum();
            double count = stats.getCount();

            System.out.println("Average area: " + avg + "\nMinimum area: " + min + "\nMaximum area: " + max + "\nSum of all areas: " + sum + "\nTotal Rectangle count: " + count + "\n");

            DoubleSummaryStatistics stats2 = objList.stream()
                                            .filter(shape -> shape.ShapeName().equals("Circle"))
                                            .mapToDouble(Shape::ShapeArea)
                                            .summaryStatistics();
            double avg2 = stats2.getAverage();
            double min2 = stats2.getMin();
            double max2 = stats2.getMax();
            double sum2 = stats2.getSum();
            double count2 = stats2.getCount();

            System.out.println("-----------------------------");
            System.out.println("Circle averages statistics: \n");
            System.out.println("Average area: " + avg2 + "\nMinimum area: " + min2 + "\nMaximum area: " + max2 + "\nSum of all areas: " + sum2 + "\nTotal Circle count: " + count2 + "\n");

        shapes.close();
    }
        

  
}