package ru.stqa.pft.sandbox;

public class Point {

  public double x;
  public double y;

  public Point(double p1, double p2) {
    this.x = p1;
    this.y = p2;
  }

  public double distance(Point p2) {
    return Math.sqrt((p2.x - this.x) * (p2.x - this.x) + (p2.y - this.y) * (p2.y - this.y));
  }

}
