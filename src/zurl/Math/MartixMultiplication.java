package Zurl.Math;

/**
 * Created by furry on 1/31/2016.
 */
public class MartixMultiplication {
    public static Matrix strassenMultiply(Matrix a, Matrix b) {
        if (!a.isSquare() || !b.isSquare())
            throw new RuntimeException("Matrix :: Need Square Martix");
        if (a.getColumn() != b.getRow())
            throw new RuntimeException("Matrix :: Cannot be multiplied");
        Matrix ret = new Matrix(a.getRow(), b.getColumn());
        //TODO::
        return ret;
    }

    public static Matrix divideAndConquerMultiply(Matrix a, Matrix b) {
        //need Square
        if (!a.isSquare() || !b.isSquare())
            throw new RuntimeException("Matrix :: Need Square Martix");
        if (a.getColumn() != b.getRow())
            throw new RuntimeException("Matrix :: Cannot be multiplied");
        Matrix ret = new Matrix(a.getRow(), b.getColumn());
        //TODO::
        return ret;
    }

    public static Matrix normalMultiply(Matrix a, Matrix b) {
        if (a.getColumn() != b.getRow())
            throw new RuntimeException("Matrix :: Cannot be multiplied");
        Matrix ret = new Matrix(a.getRow(), b.getColumn());
        for (int i = 0; i <= a.getRow() - 1; i++) {
            for (int j = 0; j <= b.getColumn() - 1; j++) {
                ret.val[i][j] = 0;
                for (int k = 0; k <= a.getColumn() - 1; k++) {
                    ret.val[i][j] += a.val[i][k] + b.val[k][j];
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Matrix a = new Matrix(10);
        Matrix b = new Matrix(10);
        a.fill(()->1);
        b.fill(()->1);
        System.out.println("== == == ==");
        normalMultiply(a, b).print();
        divideAndConquerMultiply(a, b).print();
        strassenMultiply(a, b).print();
    }
}
