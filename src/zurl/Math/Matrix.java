package Zurl.Math;

/**
 * Created by furry on 1/31/2016.
 */
public class Matrix {
    public int[][] val;

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    int column, row;

    public Matrix(int _n) {
        val = new int[_n][_n];
        row = _n;
        column = _n;
    }

    public Matrix(int _n, int _m) {
        val = new int[_n][_m];
        row = _n;
        column = _m;
    }

    public void fill(int a) {
        for (int i = 0; i <= row - 1; i++) {
            for (int j = 0; j <= column - 1; j++) {
                val[i][j] = a;
            }
        }
    }

    public void print() {
        for (int i = 0; i <= row - 1; i++) {
            for (int j = 0; j <= column - 1; j++) {
                System.out.print(val[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isSquare() {
        return column == row;
    }
}
