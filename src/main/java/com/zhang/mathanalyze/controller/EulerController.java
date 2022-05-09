package com.zhang.mathanalyze.controller;

import com.zhang.mathanalyze.algorithm.EulerMethod;
import com.zhang.mathanalyze.common.ResultResponse;
import com.zhang.mathanalyze.common.ResultUtils;
import com.zhang.mathanalyze.entity.AlgorithmOne;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;

@RestController
public class EulerController {

    private double H;
    private int  N;
    private double x0,y0;

    @RequestMapping("/Euler")
    public ResultResponse<String> Euler1(AlgorithmOne body){
        H=Double.parseDouble(body.getX());
        N=Integer.parseInt(body.getN());
//        System.out.println(H+"-------"+N);
        return ResultUtils.success("ok");
    }

    @RequestMapping("/EulerNode")
    public ResultResponse<List<Double>> Euler2(HttpServletRequest request){
        int i=0;
        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()){
            String name=parameterNames.nextElement();
            String value=request.getParameter(name);
            if(i==0){
                x0=Double.parseDouble(value);
                i++;
            }
           y0=Double.parseDouble(value);
        }
        return ResultUtils.success(EulerMethod.EulerMethods(x0, y0, H, N));
    }
}
