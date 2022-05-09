package com.zhang.mathanalyze.algorithm;

public class lglr {

    public static String lagelan(double[] x,double[] y,double[] all,double X,int n){
        for (int i = 0,j=0; i < all.length; i++) {
            if(i%2==0){
                x[j] = all[i];
                j++;
            }
        }
        for (int i = 0,j=0; i < all.length; i++) {
            if(i%2==1){
                y[j] = all[i];
                j++;
            }
        }
        double res=lglrchzh(X, n, x, y);
        return "f("+X+")≈L("+X+")="+ res;
    }

    private static double lglrchzh(double X, int n, double x[], double y[]) {
        double Y = 0;
        for (int k = 0; k <= n-1; k++) {
            double t = 1;
            for (int j = 0; j <= n-1; j++) {
                if (j == k) {
                    j = k + 1;
                    if (j > n-1) {
                        break;
                    }
                }
                t *= (X - x[j]) / (x[k] - x[j]);
            }
            Y = Y + t * y[k];
        }
        return Y;
    }
}
