package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {

        Point p1 = new Point(7, 8);
        Point p2 = new Point(10, 15);
        System.out.println("Расстояние между p1 и p2 на плоскости" + " = " + p1.distance(p2));

    }

    }