package com.zhang.mathanalyze.controller;

import com.zhang.mathanalyze.algorithm.lglr;
import com.zhang.mathanalyze.common.ResultResponse;
import com.zhang.mathanalyze.common.ResultUtils;
import com.zhang.mathanalyze.entity.AlgorithmOne;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

@Controller
public class LagrangeController {

  private   double[] x;
    private  double[] y;
    private   double[] all;
    private  double X;

    @ResponseBody
    @RequestMapping("/lglr")
    public ResultResponse<String> test6(AlgorithmOne body){
        int n=Integer.parseInt(body.getN());
//        System.out.println(body.getX());
        X=Double.parseDouble(body.getX());
        if(n>0){
            x = new double[n];
            y = new double[n];
            all=new double[2*n];
        }
        return ResultUtils.success("ok");
    }

    @ResponseBody
    @RequestMapping("/lglrNode")
    public ResultResponse<String> node(HttpServletRequest request) throws IOException {
        int i=0,j=0;
        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()){
            String name=parameterNames.nextElement();
            String value=request.getParameter(name);
            if(all.length != 0 ) {
                all[i] = Double.parseDouble(value);
                i++;
            }
        }
        return ResultUtils.success(lglr.lagelan(x,y,all,X,x.length));
    }
}
