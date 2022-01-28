package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {

        Point p1 = new Point(7, 8);
        Point p2 = new Point(10, 15);
        System.out.println("Расстояние между p1 и p2 на плоскости" + " = " + distance(p1, p2));

    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
    }

    }