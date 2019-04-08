package com.broada.three.controller;

import com.broada.three.data.vo.request.A0004Request;
import com.broada.three.data.vo.response.A0004Response;
import com.broada.three.data.vo.response.A0005Response;
import com.broada.three.data.vo.response.A0006Response;
import com.broada.three.data.vo.response.A0007Response;
import com.broada.three.service.inf.DeptnoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/three")
@Api(value = "管理Deptno的接口", tags = "管理Deptno的接口")
public class DeptnoController {

    @Autowired
    private DeptnoService deptnoService;
    private A0006Response outVo;

    @RequestMapping(value = "/dept/findOne", method = RequestMethod.GET)
    @ApiOperation(value = "根据ID查询", notes = "根据ID查询")
    public A0005Response findOne(@RequestParam Integer deptno) {
        A0005Response outVo = new A0005Response();
        try {
            outVo = deptnoService.findOne(deptno);
        } catch (Exception e) {
            log.error("通过ID查询dept错误");
        }
        return outVo;
    }

    @RequestMapping(value = "/dept/findList", method = RequestMethod.GET)
    @ApiOperation(value = "查询dept集合", notes = "查询dept集合")
    public A0006Response findList() {
        A0006Response outVo = new A0006Response();
        try {
            outVo = deptnoService.findList();
        } catch (Exception e) {
            log.error("查询dept集合失败");
        }
        return outVo;
    }

    @RequestMapping(value = "/dept/findPercent", method = RequestMethod.GET)
    @ApiOperation(value = "查询部门的占比", notes = "查询部门的占比")
    public A0007Response findPercent(@RequestParam Integer deptno) {
        A0007Response outVo = new A0007Response();
        try {
            outVo = deptnoService.findPercent(deptno);
        } catch (Exception e) {
            log.error("查询占比出错~!");
        }
        return outVo;
    }
    @RequestMapping(value = "dept/getList",method = RequestMethod.POST)
    @ApiOperation(value = "复杂查询",notes = "dept复杂查询")
    public A0006Response getList(@RequestBody A0004Request request){
        A0006Response outVo = new A0006Response();
        try {
            outVo=deptnoService.getList(request);
        } catch (Exception e) {
            log.error("复杂查询出现错误");
        }
        return outVo;
    }

}
