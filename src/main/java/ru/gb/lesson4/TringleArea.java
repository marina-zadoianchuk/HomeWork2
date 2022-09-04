package ru.gb.lesson4;

public class TringleArea {

    private int a;
    private int b;
    private int c;
    private double S;

    public TringleArea (int a, int b, int c) throws TriangleExeption {
        this.a = a;
        this.b = b;
        this.c = c;
     //   this.S = S;

     }
    public double getS() throws TriangleExeption {
        if (this.a <= 0 || this.b <= 0 || this.c <= 0) {
            throw new TriangleExeption();
        }
        int p = (a + b + c) / 2;
        S = Math.sqrt(p *(p - a)*(p - b)*(p - c));
        return S;
    }

    @Override
    public String toString() {
        return "TriangleArea{" +
                "S=" + S;
    }
}
