package com.zhang.mathanalyze.algorithm;

public class Newtoninterpolate {

//    public static void main(String[] args) {
//        double[]node=new double[]{0.40,0.41075,0.55,0.57815,0.65,0.69675,0.80,0.88811,0.90,1.02652,1.05,1.25386};
//        double[] node1=new double[]{1,1,3,2,2,-1};
//        Newtoninterpolate.niu(3,node1,1.5);
//    }

    static double[][] format;

public static String  niu(int n,double[] node,double x){

    double[][] xy=new double[2][n];//二维数组来存储x和y
    for(int j=0,i=0;j<2*n;j++) {
        if(j%2==0) {
            xy[0][i] = node[j];//第0行放各点的x值
            i++;
        }
    }
    for(int j=0,i=0;j<2*n;j++) {
        if(j%2==1) {
            xy[1][i] = node[j];//第1行放各点的y值
            i++;
        }
    }
    creatformat(xy, n);
//    int v=in.nextInt();//所求点的总数
//    for(int i=0;i<v;i++) {
//        double x=in.nextDouble();
//        System.out.print("f("+x+")≈"+"Nn("+x+")"+"=");
//        System.out.printf("%.5f", Nn(xy, n, x));
//        System.out.println();
        return "f("+x+")≈"+"Nn("+x+")"+"="+ Nn(xy, n, x);
//    }
}


    public static void creatformat(double[][] xy,int n) {
        format=new double[n-1][n-1];
        for(int i=0;i<n-1;i++) {
            for(int j=0;j<n-1-i;j++) {
                if(i==0) {
                    format[i][j]=(xy[1][j]-xy[1][j+1])/(xy[0][j]-xy[0][j+1]);
                }
                else{
                    format[i][j]=(format[i-1][j]-format[i-1][j+1])/(xy[0][j]-xy[0][j+i+1]);
                }
            }
        }
    }

    public static double Nn(double[][] xy, int n, double x) {
        //牛顿插值公式
        double sum=xy[1][0];//求和的初始值为f(X0)
        for(int i=0;i<n-1;i++) {
            double c=1;
            for(int j=0;j<i+1;j++) {
                c=(x-xy[0][j])*c;
            }
            sum=sum+format[i][0]*c;
        }
        return sum;
    }
}
