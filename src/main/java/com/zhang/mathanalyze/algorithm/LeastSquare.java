package com.zhang.mathanalyze.algorithm;

public class LeastSquare {
    public static String Line(double[] x,double[] y){
        double t1=0,t2=0,t3=0,t4=0;
        for (int i=0;i<x.length;i++){
            t1+=x[i]*x[i];
            t2+=x[i];
            t3+=y[i];
            t4+=x[i]*y[i];
        }
        double a=(t4*x.length-t2*t3)/(t1*x.length-t2*t2);
        double b=t3/x.length-a*t2/x.length;
        return "y="+String.format("%.2f",b)+"+"+String.format("%.2f",a)+"X";
    }

//    public static void main(String[] args) {
//        double[] x=new double[]{0,0.2,0.4,0.6,0.8};
//        double[] y=new double[]{0.9,1.9,2.8,3.3,4.2};
//        System.out.println(LeastSquare.Line(x,y));;
//    }
}
