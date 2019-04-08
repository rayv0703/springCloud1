package com.broada.three.service.impl;

import com.broada.cm.consts.Constants;
import com.broada.three.data.domain.Emp;
import com.broada.three.data.domain.EmpBo;
import com.broada.three.data.domain.EmpDetail;
import com.broada.three.data.mapper.EmpMapper;
import com.broada.three.data.vo.request.A0001Request;
import com.broada.three.data.vo.request.A0003Request;
import com.broada.three.data.vo.response.*;
import com.broada.three.service.inf.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    /**
     * 根据条件查询员工信息
     * @param request
     * @return
     */
    @Override
    public A0001Response getEmpDetail(A0001Request request) {
        A0001Response responseVo = new A0001Response();
        Emp emp = new Emp();
        BeanUtils.copyProperties(request,emp);
        List<Emp> empList= empMapper.getEmpDetail(emp);
        if (empList.isEmpty()) {
            log.info("根据条件查询员工信息,查询结果为空");
            return responseVo;
        }
        responseVo.setEmpList(empList);
        return responseVo;
    }

    /**
     * 查询员工列表
     * @return
     */
    @Override
    public A0002Response getList() {
        A0002Response responseVo = new A0002Response();
        List<Emp> list=empMapper.getList();
        responseVo.setEmpList(list);
        return responseVo;
    }

    /**
     * 根据复杂条件查询
     * @param request
     * @return
     */
    @Override
    public A0003Response searchEmpList(A0003Request request) {
        A0003Response responseVo = new A0003Response();
        log.info("复杂条件查询条件为:"+request.toString());
        EmpBo bo = new EmpBo();
        BeanUtils.copyProperties(request,bo);
        List<Emp> empList=empMapper.searchEmpList(bo);
        responseVo.setEmpList(empList);
        return responseVo;
    }

    /**
     *  添加员工信息
     * @param request
     * @return
     */
    @Override
    public A0004Response addEmpInf(A0001Request request) {
        A0004Response outVo = new A0004Response();
        Emp emp = new Emp();
        BeanUtils.copyProperties(request,emp);
        int num=empMapper.addEmpInf(emp);
        if (num==1) {
            log.info("添加员工信息成功");
            outVo.setTxStatus(Constants.SUCCESS);
        }else {
            log.info("添加员工信息失败");
            outVo.setTxStatus(Constants.FAIL);
        }
        return outVo;
    }

    /**
     * 修改员工信息
     * @param request
     * @return
     */
    @Override
    public A0004Response updateEmpInf(A0001Request request) {
        A0004Response outVo = new A0004Response();
        //Assert.assertEquals("传入参数有问题,传入empno了" ,null,request.getDeptno());
        Emp emp = new Emp();
        BeanUtils.copyProperties(request,emp);
        int num = empMapper.updateEmpInf(emp);
        if (num>0){
            outVo.setTxStatus("200");
            log.info("修改员工信息成功");
        }else{
            outVo.setTxStatus("500");
            log.info("修改员工信息失败");
        }
        return outVo;
    }

    /**
     * 删除员工信息
     * @param empno
     * @return
     */
    @Override
    public A0004Response deleteEmpInf(Integer empno) {
        A0004Response outVo = new A0004Response();
        try {
            empMapper.deleteEmpInf(empno);
            outVo.setTxStatus("200");
            return outVo;
        } catch (Exception e) {
            outVo.setTxStatus("500");
            return outVo;
        }
    }

    @Override
    public A0002Response findByIds(List<Integer> ids) {
        return empMapper.findByIds(ids);
    }

    @Override
    public A0008Response findList() {
        A0008Response outVo = new A0008Response();
        List<EmpDetail> list = empMapper.findList();
        log.info("查出结合为"+list.toString());
        outVo.setEmpDetailList(list);
        return outVo;
    }
}
