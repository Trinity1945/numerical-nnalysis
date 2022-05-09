package com.zhang.mathanalyze.controller;

import com.zhang.mathanalyze.algorithm.LeastSquare;
import com.zhang.mathanalyze.common.ResultResponse;
import com.zhang.mathanalyze.common.ResultUtils;
import com.zhang.mathanalyze.entity.AlgorithmOne;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Controller
public class LeastErController {

    private int N;

    private double[] all;

    private double[] x;

    private double[] y;

    @ResponseBody
    @RequestMapping("/LeastSqure")
    public ResultResponse<String> lesat(AlgorithmOne body){
        N=Integer.parseInt(body.getN());
        if(N>0){
            all=new double[N*2];
        }
        return ResultUtils.success("ok");
    }

    @ResponseBody
    @RequestMapping("/LeastNode")
    public ResultResponse<String> lesa1t(HttpServletRequest request){
            int i=0;
            Enumeration<String> parameterNames = request.getParameterNames();
            while(parameterNames.hasMoreElements()){
                String name=parameterNames.nextElement();
                String value=request.getParameter(name);
//                System.out.println(value);
                if(all!=null){
                    all[i]=Double.parseDouble(value);
                    i++;
                }
        }
            x=new double[N];
            y=new double[N];
            for(int j=0,k=0;j<all.length;j++){
                if(j%2==0){
                    x[k]=all[j];
                    k++;
                }
            }
        for(int j=0,k=0;j<all.length;j++){
            if(j%2==1){
                y[k]=all[j];
                k++;
            }
        }
        return ResultUtils.success(LeastSquare.Line(x,y));
    }
}
