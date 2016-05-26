package ru.stqa.pft.sandbox;

/**
 * Created by kompu on 5/22/2016.
 */
public class MyFirstProgram {

public static void main(String[] arg){
  Calculator calc = new Calculator();
  calc.type(2);
  calc.store();
  calc.mult(2);
  calc.addToMemory();
  System.out.print("Memory: " + calc.memory + ", display: " + calc.display);


  }
}
