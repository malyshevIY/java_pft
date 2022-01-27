package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {
        hellow("world");
        hellow("user");
        hellow("Ilya");

        double l = 5;
        System.out.println("Площаль квадрата со стороной " + l + " = " + area(l));

        double a = 4;
        double b = 6;
        System.out.println("Площаль треугольника со сторонами " + a + " и " + b + " = " + area(a, b));

    }

    public static void hellow(String somebody) {
        System.out.println("Hellow, " + somebody + "!");
    }

    public static double area (double len) {
        return len * len;
    }

    public static double area (double a, double b) {
        return a * b;
    }

}