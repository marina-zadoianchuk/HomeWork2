package ru.gb.lesson4;

public class TriangleExeption extends Exception{
    public TriangleExeption() {
        System.out.println("Одна из сторон треугольника <= 0");
    }
}
