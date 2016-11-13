package com.example.jason.linearalgebraapp.Activities.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import com.example.jason.linearalgebraapp.R;

/**
 * Created by jason on 11/13/2016.
 */

public class MatrixOperations {


    public static int dotProduct(int[] v1, int[] v2) {
        int sum = 0;
        for (int i = 0; i < v1.length; i++) {
            sum += v1[i] + v2[i];
        }
        return sum;
    }

    public static double[][] rowReducer(double[][] B) {
        int m = B.length;
        int n = B[0].length;
        int add = 0;

        int[] colSum = new int[n];
        int count = 0;
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                colSum[a] += B[b][a];
            }
            if (colSum[a] != 0) {
                count++;
            }
        }
        double[][] temp = new double[m][count];
        int fact = 0;
        for (int a = 0; a < n; a++) {
            if (colSum[a] == 0) {
                while (colSum[a] == 0) {
                    a++;
                    fact++;
                }
            }
            for (int b = 0; b < m; b++) {
                temp[b][a - fact] = B[b][a];
            }
        }
        double[][] A = temp;
        m = A.length;
        n = A[0].length;
        System.out.println(m + " " + n);
        int less = 0;
        if (m < n) {
            less = m;
        } else {
            less = n;
        }
        for (int i = 0; i < less; i++) {
            if (A[i][i] == 0) {
                int a = i + 1;
                while (a < m && A[a][i] == 0) {
                    a++;
                }
                if (a != m) {
                    for (int k = 0; k < n; k++) {
                        A[i][k] = A[a][k] + A[i][k];
                        A[a][k] = A[i][k] - A[a][k];
                        A[i][k] = A[i][k] - A[a][k];
                    }
                }
            }
            int sum = 0;
            for (int k = 0; k < m; k++) {
                sum += A[k][i];
            }
            if (sum == 0) {
                add++;
            }
            double div = A[i][i];
            for (int k = 0; k < n; k++) {
                A[i][k] /= div;
            }

            for (int j = i + 1; j < m; j++) {
                double mult = A[j][i];

                for (int l = i + add; l < n; l++) {
                    A[j][l] += -1 * mult * A[i][l];
                }
            }
        }
        double[][] out = new double[m][n];
        for (int a = 0; a < m; a++) {
            for (int b = 0; b < n; b++) {
                if (A[a][b] != A[a][b] | A[a][b] == Double.POSITIVE_INFINITY) {
                    out[a][b] = 0;
                } else {
                    out[a][b] = A[a][b];
                }
            }
        }
        double[][] newOut = new double[B.length][B[0].length];
        ArrayList<Integer> filledColumns = new ArrayList<Integer>();
        for (int i = 0; i < colSum.length; i++) {
            if (colSum[i] != 0) {
                filledColumns.add(new Integer(i));
            }
        }
        for (int k = 0; k < out[0].length; k++) {
            int curCol = filledColumns.remove(0);
            for (int i = 0; i < out.length; i++) {
                newOut[i][curCol] = out[i][k];
            }
        }




        return newOut;
    }

    public static double[][] matrixMultiplication(double[][] A, double[][] B) {
        int m = A.length;
        int n = A[0].length;
        int p = B.length;
        int q = B[0].length;
        if(n == p)
        {
            double[][] out = new double[m][q];

            for(int a = 0; a < m; a++) {

                for(int b = 0; b < q; b++) {
                    for(int c = 0; c < n; c++) {
                        out[a][b] += A[a][c]*B[c][b];
                    }
                }
            }
            return out;
        } else {
            return new double[m][q];
        }
    }

    public static double[][] powers(double[][] A, int k) {
        double[][] t = A;
        for(int i = 0; i < k-1; i++ ) {
            A = matrixMultiplication(A,t);
        }

        return A;
    }



}
