package ru.kpfu.itis.group11408.Miftahutdinova.matrixmultiplication;

import java.util.Random;

public class MatrixMultiplication {
    private int[][] a;
    private int[][] b;
    private static int[][] res;

    public MatrixMultiplication() {
        Random rd = new Random();
        int size = (int) (Math.random() * 1800 + 200);
        this.a = new int[size][size];
        this.b = new int[size][size];
        res = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = rd.nextInt(1000);
                b[i][j] = rd.nextInt(1000);
            }
        }
        printMatrix(a);
        System.out.println("---------------------");
        printMatrix(b);
        System.out.println("---------------------");
    }


    private class Multiplicator implements Runnable {

        int from, to;

        public Multiplicator(int from, int to){
            this.from = from;
            this.to = to;
        }

        private void multiply(){
            for (int i = from; i < to; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    for (int k = 0; k < b.length; k++){
                        res[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
        }

        @Override
        public void run() {
            multiply();
        }
    }

    public static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MatrixMultiplication matrixMult = new MatrixMultiplication();
        final int threadsNumber = 10;
        int from = 0, to = res.length / threadsNumber;
        Multiplicator[] multiplicators = new Multiplicator[threadsNumber];
        Thread thread = null;
        for (int i = 0; i < multiplicators.length; i++) {
            multiplicators[i] = matrixMult.new Multiplicator(from, to);
            thread = new Thread(multiplicators[i]);
            thread.start();
            from = to;
            to += res.length / threadsNumber;
        }
        if (thread.isAlive()) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printMatrix(res);
        }
    }
}