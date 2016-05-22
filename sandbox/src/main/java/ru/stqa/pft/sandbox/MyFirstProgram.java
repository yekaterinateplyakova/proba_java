package ru.stqa.pft.sandbox;

/**
 * Created by kompu on 5/22/2016.
 */
public class MyFirstProgram {
    public static void main(String[] arg) {
        hello("worl");
        hello("Kate ");
        hello("Olya ");

        double len = 5;
        System.out.println(area(len));

        double a = 4;
        double b = 6;
        System.out.println(area(a,b));

    }
    public static void hello( String somebody){
        System.out.println("Hello " + somebody);
    }

    public static double area(double l){
        return l * l;
    }
    public static double area(double a, double b){
        return a * b;
    }
}
