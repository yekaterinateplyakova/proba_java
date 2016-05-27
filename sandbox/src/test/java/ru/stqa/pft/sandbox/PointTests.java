package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by kompu on 5/27/2016.
 */
public class PointTests {

  @Test
  public void testDistance(){
    Point p1 = new Point(1, 6);
    Point p2 = new Point(4,2);
    Assert.assertEquals(p1.distance(p2),5.0);
    Assert.assertEquals(p1.distance(p2), p2.distance(p1));
    Assert.assertEquals(p2.distance(p1), 5.0);
    Assert.assertTrue(p1.distance(p2) >= 0);
  }
  

}
