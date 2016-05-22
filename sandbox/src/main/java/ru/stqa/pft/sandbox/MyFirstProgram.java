package ru.stqa.pft.sandbox;

/**
 * Created by kompu on 5/22/2016.
 */
public class MyFirstProgram {
    public static void main(String[] arg) {
        hello("worl");
        hello("Kate ");
        hello("Olya ");

        Square s = new Square(5);
        System.out.println(area(s));

        Rectangle r = new Rectangle(4,7);
        System.out.println(area(r));

    }
    public static void hello( String somebody){
        System.out.println("Hello " + somebody);
    }

    public static double area(Square s){
        return s.l * s.l;
    }

    public static double area(Rectangle r){
        return r.a * r.b;
    }
}
