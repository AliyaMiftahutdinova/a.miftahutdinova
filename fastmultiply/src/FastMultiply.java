package ru.kpfu.itis.group11408.Miftahutdinova.fastmultiply;

import java.util.Scanner;

public class FastMultiply {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        FastMultiply mult = new FastMultiply();
        System.out.println(mult.multiply(scan.nextInt(), scan.nextInt(), scan.nextInt()));
    }

    public int multiply(int X, int Y, int n){
        int sign = sign(X, Y);
        X = Math.abs(X);
        Y = Math.abs(Y);
        if (n == 1){
            if(X == 1 && Y == 1){
                return sign;
            }else{
                return 0;
            }
        }else{
            int A = binary(X, true);//левые биты X
            int B = binary(X, false);//правые биты X
            int C = binary(Y, true);//левые биты Y
            int D = binary(Y, false);//правые биты Y
            int m1 = multiply(A, C, n / 2);
            int m2 = multiply(A - B, C - D, n / 2);
            int m3 = multiply(B, D, n / 2);
            return (int)(sign * (m1 * Math.pow(2 , n) + (m1 + m2 + m3) * Math.pow(2, n / 2) + m3));
        }
    }

    private int sign(int X, int Y){
        return ((X / (- X)) * (Y / (- Y)));
    }

    private int binary(int X, boolean left){
        String binarynumber = Integer.toBinaryString(X);
        int size = binarynumber.length();
        if(left){
            return Integer.parseInt((binarynumber.substring(0, size)), 2);
        }
        return Integer.parseInt((binarynumber.substring(size, binarynumber.length()-1)), 2);
    }
}
