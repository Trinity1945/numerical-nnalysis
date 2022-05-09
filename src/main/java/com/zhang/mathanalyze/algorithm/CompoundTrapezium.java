package com.zhang.mathanalyze.algorithm;

public class CompoundTrapezium {

    //复化梯形公式
    public static String compoundTrapezium(double a,double b,double h){

        double value=0;	  //记录最终数值
        double contain=0; //记录一个中间值
        for(double k=1;k<=h-1;k++){
            contain=contain+f(a+k*((b-a)/h));   //调用公式
        }
        contain=2*contain;			//调用公式
        value=((b-a)/(2*h))*(f(a)+f(b)+contain);  //调用公式

//        System.out.println("通过给定的公式、指定的上下限和区间分成份数，可以得到结果为："+value);
        return String.valueOf(String.format("%.4f",value));
    }

    //用给定公式计算相应数值
    public static double f(double x) {

        double value=0; //记录经过公式算出来的值

//        value=1/(1+x*x); //题目中给定公式，需要手动更改

        value=Math.sqrt(x);
        return value;
    }
}
