package com.zhang.mathanalyze.controller;

import com.zhang.mathanalyze.algorithm.Newtoninterpolate;
import com.zhang.mathanalyze.common.ResultResponse;
import com.zhang.mathanalyze.common.ResultUtils;
import com.zhang.mathanalyze.entity.AlgorithmOne;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Controller
public class NewtonController {

    private double[] node;

    private int N;

    private double X;

    @ResponseBody
    @RequestMapping("/newton")
    ResultResponse<String> newton1(AlgorithmOne body){
        N=Integer.parseInt(body.getN());
        X=Double.parseDouble(body.getX());
        System.out.println(X+"-------"+N);
        if(N>0){
            node=new double[2*N];
        }
        return ResultUtils.success("ok");
    }

    @ResponseBody
    @RequestMapping("/newtonNode")
    public ResultResponse<String> newton2(HttpServletRequest request){
        int i=0;
        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()){
            String name=parameterNames.nextElement();
            String value=request.getParameter(name);
            System.out.println(value);
           if(node!=null){
               node[i]=Double.parseDouble(value);
               i++;
           }
        }
        return ResultUtils.success(Newtoninterpolate.niu(N,node,X));
    }

}
