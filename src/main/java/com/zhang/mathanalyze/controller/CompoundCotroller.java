package com.zhang.mathanalyze.controller;

import com.zhang.mathanalyze.algorithm.CompoundTrapezium;
import com.zhang.mathanalyze.common.ResultResponse;
import com.zhang.mathanalyze.common.ResultUtils;
import com.zhang.mathanalyze.entity.ConpoundBody;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CompoundCotroller {

    @ResponseBody
    @RequestMapping("/compound")
    public ResultResponse<String> compounds1(ConpoundBody body){
        double floor=Double.parseDouble(body.getFloor());
        double upper=Double.parseDouble(body.getUpper());
        double copies=Double.parseDouble(body.getCopies());
        return ResultUtils.success(CompoundTrapezium.compoundTrapezium(floor,upper,copies));
    }

}
