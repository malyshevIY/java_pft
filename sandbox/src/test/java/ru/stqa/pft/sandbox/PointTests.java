package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testDistance() {
    Point a = new Point(7, 8);
    Point b = new Point(10, 15);
    Assert.assertEquals(a.distance(b), 7.615773105863909);

  }

  @Test
  public void testDistance1() {
    Point a = new Point(-7, -8);
    Point b = new Point(-10, -15);
    Assert.assertEquals(a.distance(b), 7.615773105863909);

  }

  @Test
  public void testDistance2() {
    Point a = new Point(7, 8);
    Point b = new Point(10, 15);
    Assert.assertNotEquals(a.distance(b), 8);

  }
}


