package com.zhang.mathanalyze.algorithm;

import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;

public class LeastSquareMethod2 {

    public static String Least(double[] X,double[] Y){
        WeightedObservedPoints obs = new WeightedObservedPoints();
        for(int i=0;i<X.length;i++){
            obs.add(X[i], Y[i]);
        }
        // Instantiate a third-degree polynomial fitter.
        PolynomialCurveFitter fitter = PolynomialCurveFitter.create(2);

        // Retrieve fitted parameters (coefficients of the polynomial function).
        final double[] coeff = fitter.fit(obs.toList());
        String fun = "f(x) = ";
        for (int i = coeff.length - 1; i >= 0; i--) {
            String add = coeff[i] > 0 ? "+" : "";
            String x = i > 0 ? "x^" + i : "";
            if (i == coeff.length - 1) {
                fun += (coeff[i] + x);
            } else {
                fun += (add + coeff[i] + x);
            }
        }
        System.out.println("Function is: " + fun);
        return fun;
    }
}
