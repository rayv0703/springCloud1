package com.broada.three.controller;

import com.broada.three.data.vo.request.A0001Request;
import com.broada.three.data.vo.request.A0003Request;
import com.broada.three.data.vo.response.*;
import com.broada.three.service.inf.EmpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(value = "管理员工的接口",tags = "管理员工的接口")
@RequestMapping("/three")
@Slf4j
public class EmpController {

    @Autowired
    private EmpService empService;

    @RequestMapping(value = "/emp/getEmpDetail", method = RequestMethod.POST)
    @ApiOperation("条件查询员工")
    public A0001Response getEmpDetail(@RequestBody @Valid A0001Request request) {
        A0001Response responseVo = new A0001Response();
        try {
            responseVo = empService.getEmpDetail(request);
        } catch (Exception e) {
            log.error("条件查询员工错误");
        }
        return responseVo;
    }

    @RequestMapping(value = "/emp/searchEmpList", method = RequestMethod.POST)
    @ApiOperation(value = "复杂条件查询", notes = "")
    public A0003Response searchEmpList(@RequestBody @Valid A0003Request request) {
        A0003Response responseVo = new A0003Response();
        try {
            responseVo = empService.searchEmpList(request);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("复杂条件查询错误");
        }
        return responseVo;
    }

    @RequestMapping(value = "/emp/getList", method = RequestMethod.GET)
    @ApiOperation("查询所有")
    public A0002Response getList() {
        A0002Response responseVo = new A0002Response();
        try {
            responseVo = empService.getList();
        } catch (Exception e) {
            log.error("查询所有错误");
        }
        return responseVo;
    }

    @ApiOperation(value = "新增员工", tags = "")
    @RequestMapping(value = "/emp/addEmpInf", method = RequestMethod.POST)
    public A0004Response addEmpInf(@RequestBody A0001Request request) {
        A0004Response outVo = new A0004Response();
        try {
            outVo = empService.addEmpInf(request);
        } catch (Exception e) {
            log.error("新增员工错误");
        }
        return outVo;
    }

    @ApiOperation(value = "修改员工信息", notes = "")
    @RequestMapping(value = "/emp/updateEmpInf/{empno}", method = RequestMethod.PUT)
    public A0004Response updateEmpInf(@RequestBody A0001Request request, @PathVariable(name = "empno") Integer empno) {
        A0004Response outVo = new A0004Response();
        request.setEmpno(empno);
        try {
            outVo = empService.updateEmpInf(request);
        } catch (Exception e) {
            log.error("修改员工信息错误");
        }
        return outVo;
    }

    @ApiOperation(value = "删除员工信息", notes = "")
    @RequestMapping(value = "/emp/deleteEmpInf/{id}", method = RequestMethod.DELETE)
    public A0004Response deleteEmpInf(@RequestParam(name = "id", required = true) Integer empno) {
        A0004Response outVo = new A0004Response();
        try {
            outVo = empService.deleteEmpInf(empno);
        } catch (Exception e) {
            log.error("删除员工信息错误");
        }
        return outVo;
    }
    @ApiOperation(value = "查询empno中的员工信息")
    @RequestMapping(value = "/emp/findIds",method = RequestMethod.POST)
    public A0002Response findIds(@RequestParam(name = "ids",required = true) List<Integer> ids){
        A0002Response outVo = new A0002Response();
        try {
            outVo=empService.findByIds(ids);
        } catch (Exception e) {
            log.error("通过ids查询emp失败");
        }
        return outVo;
    }
    @ApiOperation(value = "emp关联查询",notes = "进行测试")
    @RequestMapping(value = "/emp/findList",method = RequestMethod.GET)
    public A0008Response findList(){
        A0008Response outVo = new A0008Response();
        try {
            outVo=empService.findList();
        } catch (Exception e) {
            log.error("emp关联查询失败");

        }
        return outVo;
    }
}
