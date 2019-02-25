package com.broada.three.controller;

import com.broada.three.data.vo.request.A0001Request;
import com.broada.three.data.vo.response.A0001Response;
import com.broada.three.service.inf.EmpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api("管理员工的接口")
@RequestMapping("/three")
public class EmpController {

    @Autowired
    private EmpService empService;

    @RequestMapping(value = "/emp/getEmpDetail",method = RequestMethod.POST)
    @ApiOperation("条件查询员工")
    public A0001Response getEmpDetail(@RequestBody @Valid A0001Request request){
        A0001Response responseVo = new A0001Response();
        try {
            responseVo=empService.getEmpDetail();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseVo;
    }
}
