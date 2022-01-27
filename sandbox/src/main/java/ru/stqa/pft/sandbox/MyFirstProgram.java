package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {

        Point p = new Point(5,7);
        System.out.println("Расстояние между точкой p1 и p2 на двумерной плоскости" + " = " + p.distance());

    }
}