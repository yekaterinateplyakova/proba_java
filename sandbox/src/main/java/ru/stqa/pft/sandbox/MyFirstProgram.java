package ru.stqa.pft.sandbox;

/**
 * Created by kompu on 5/22/2016.
 */
public class MyFirstProgram {

    System.out.println("Truck = " + price1.getTruckCount() );
    System.out.println("Car = " + price1.getCarCount());
    System.out.println("Bus = " + price1.getBusCount());
    System.out.println("TotalCount  = " + price1.getTotalCount());
    System.out.println("TotalSum = " + price1.getTotalSum());
public static void main(String[] arg){
  Calculator calc = new Calculator();
  calc.type(2);
  calc.store();
  calc.mult(2);
  calc.addToMemory();
  System.out.print("Memory: " + calc.memory + ", display: " + calc.display);


  }
}
