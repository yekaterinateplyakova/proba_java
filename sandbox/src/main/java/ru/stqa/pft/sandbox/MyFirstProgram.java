package ru.stqa.pft.sandbox;

/**
 * Created by kompu on 5/22/2016.
 */
public class MyFirstProgram {
//  public static void main(String[] arg) {
//
//    Point p1 = new Point(5, 2);
//    Point p2 = new Point(4, 1);
//    System.out.println("Расстояние между двумя точками вызванно функцией = " + distance(p1, p2));
//    System.out.println("Расстояние мужду двумя точками вызванно методом =" + p1.distance(p2));
//  }
//
//  public static double distance(Point p1, Point p2) {
//    double distance;
//    distance = Math.sqrt(((p2.x - p1.x) * (p2.x - p1.x)) + ((p2.y - p1.y) * (p2.y - p1.y)));
//    return distance;
//
//  }


  public static void main(String[] arg){
    Transpander price1 = new Transpander(20,30,10);
    price1.truck();
    price1.truck();
    price1.bus();
    price1.bus();
    price1.bus();
    price1.car();
    price1.car();

    System.out.println("Truck = " + price1.getTruckCount() );
    System.out.println("Car = " + price1.getCarCount());
    System.out.println("Bus = " + price1.getBusCount());
    System.out.println("TotalCount  = " + price1.getTotalCount());
    System.out.println("TotalSum = " + price1.getTotalSum());
  }
}
