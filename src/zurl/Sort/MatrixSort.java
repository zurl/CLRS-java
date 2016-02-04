package Zurl.Sort;

import Zurl.Math.MartixMultiplication;
import Zurl.Math.Matrix;

/**
 * Created by furry on 2/2/2016.
 */
public class MatrixSort {
    public static void maxify(Matrix m, int x, int y) {
        //O(m+n)
        if (x < m.getRow() - 1 && m.get(x + 1, y) > m.get(x, y) &&
                !(y < m.getColumn() - 1 && m.get(x, y + 1) > m.get(x, y)
                        && m.get(x + 1, y) < m.get(x, y + 1))) {
            int t = m.get(x + 1, y);
            m.set(x + 1, y, m.get(x, y));
            m.set(x, y, t);
            //recur
            maxify(m, x + 1, y);
        }
        if (y < m.getColumn() - 1 && m.get(x, y + 1) > m.get(x, y) &&
                !(x < m.getRow() - 1 && m.get(x + 1, y) > m.get(x, y)
                        && m.get(x + 1, y) > m.get(x, y + 1))) {
            int t = m.get(x, y + 1);
            m.set(x, y + 1, m.get(x, y));
            m.set(x, y, t);
            //recur
            maxify(m, x, y + 1);
        }
    }

    public static void sort(Matrix m) {
        if (m.getColumn() != m.getRow())
            throw new RuntimeException("Need N*N Matrix");

        for (int i = m.getColumn(); i >= 1; i--) {
            for (int j = m.getColumn(); j >= i; j--) {
                maxify(m, j - 1, m.getColumn() + i - j - 1);
            }
        }
        for (int i = 2; i <= m.getColumn(); i++) {
            for (int j = m.getColumn() - i + 1; j >= 1; j--) {
                maxify(m, j - 1, m.getColumn() - j - i + 1);
            }
        }
    }

    public static boolean checkMatrix(Matrix m) {
        for (int i = 1; i <= m.getRow() - 1; i++) {
            for (int j = 1; j <= m.getColumn() - 1; j++) {
                if (i != m.getRow() - 1 && m.get(i + 1, j) > m.get(i, j)) return false;
                if (j != m.getColumn() - 1 && m.get(i, j + 1) > m.get(i, j)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        final int N = 5;
        Matrix m = new Matrix(N);
        m.fill(() -> (int) (Math.random() * 1000));
        m.print();
        System.out.println(checkMatrix(m));
        sort(m);
        System.out.println();
        m.print();
        System.out.println(checkMatrix(m));
    }
}
