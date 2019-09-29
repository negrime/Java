package com.company;

public class Matrix {

    private float[][] array;
    private int rows;
    private int columns;

    public Matrix(int m, int n) {
        rows = m;
        columns = n;
        array = new float[rows][columns];
    }

    public void Generate() {
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                int random_number1 = 0 + (int) (Math.random() * 10);
                this.array[i][j] = random_number1;
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void SetValue(int i, int j, float value) {
        array[i][j] = value;
    }

    public float GetValue(int i, int j) {
        return array[i][j];
    }

    public void Print() {
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                System.out.print("\t" + this.array[i][j]);
            }
            System.out.println();
        }
    }

    public Matrix Multiply(Matrix b) throws Exception {
        Matrix result = null;
        if (this.getRows() == b.getColumns()) {
            int m = this.array.length;
            int n = b.array[0].length;
            int o = b.array.length;
            int[][] res = new int[m][n];
            result = new Matrix(m, n);

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < o; k++) {
                        result.array[i][j] += this.array[i][k] * b.array[k][j];
                    }
                }
            }
        } else
            throw new Exception("Неверный формат матриц!");
        return result;
    }


}
