package ru.stqa.pft.sandbox;

/**
 * Created by kompu on 5/22/2016.
 */
public class Point {
  public double x;
  public double y;

  public Point(double x, double y){
    this.x = x;
    this.y = y;
  }

  public double distance(Point p) {
    double distance ;
    distance = Math.sqrt(((this.x - p.x) * (this.x - p.x)) + ((this.y - p.y)*(this.y - p.y)));
    return distance;

  }

}
