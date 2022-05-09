package com.zhang.mathanalyze.algorithm;

import java.util.ArrayList;
import java.util.List;

public class EulerMethod {

   public static double f(double x,double y){
//        return 10*x*(1-y);
        return (y/x)+(x/y);
    }

   public static double[] Euler(double x0,double y0,double h,int N){
        double[] Y=new double[N];
        double x=x0;
        Y[0]=y0;
        for (int n=1;n<N;n++){
            Y[n]=Y[n-1]+h*f(x,Y[n-1]);
            x+=h;
        }
        return Y;
    }

//    public static void main(String[] args) {
//            System.out.println("请输入步长h和N");
//            double x0=1,y0=1,h=0.1;
//            int N=10;
//          double[] Y= EulerMethod.Euler(x0,y0,h,N);
//        System.out.println("欧拉公式计算误差：");
//            for(int i=0;i<N;i++){
//                System.out.println(x0+i*h+"--------"+Y[i]);
//            }
//        System.out.println("欧拉公式计算误差：");
//    }

    public static List<Double> EulerMethods(double x0, double y0, double h, int N){
        double[] Y= EulerMethod.Euler(x0,y0,h,N+1);
        List<Double> res=new ArrayList<>();
        for(int i=0;i<N;i++){
            String format = String.format("%.4f", x0 + i * h);
            String format1 = String.format("%.4f", Y[i]);
            res.add(Double.parseDouble(format));
            res.add(Double.parseDouble(format1));
            System.out.println(format +"--------"+format1);
        }
        return res;
    }
}
