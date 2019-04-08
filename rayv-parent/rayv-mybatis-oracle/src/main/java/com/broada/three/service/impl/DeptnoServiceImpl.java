package com.broada.three.service.impl;

import com.broada.three.data.domain.Dept;
import com.broada.three.data.domain.DeptBo;
import com.broada.three.data.mapper.DeptnoMapper;
import com.broada.three.data.vo.request.A0004Request;
import com.broada.three.data.vo.response.A0005Response;
import com.broada.three.data.vo.response.A0006Response;
import com.broada.three.data.vo.response.A0007Response;
import com.broada.three.service.inf.DeptnoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@Transactional
@Slf4j
public class DeptnoServiceImpl implements DeptnoService {

    @Autowired
    private DeptnoMapper deptnoMapper;


    @Override
    public A0005Response findOne(Integer deptno) {
        A0005Response outVo = new A0005Response();
        Dept dept=deptnoMapper.findOne(deptno);
        if (null != dept){
            BeanUtils.copyProperties(dept,outVo);
        }else{
            log.info("查询ID为:"+deptno+"结果为空");
        }
        return outVo;
    }

    @Override
    public A0006Response findList() {
        A0006Response outVo = new A0006Response();
        List<Dept> deptList=deptnoMapper.findList();
        if (null != deptList && deptList.size()>0){
            outVo.setDeptList(deptList);
        }
        return outVo;
    }

    @Override
    public A0007Response findPercent(Integer deptno) {
        A0007Response outVo = new A0007Response();
        //Integer totalCount = deptnoMapper.findTotalCount();
        BigDecimal totalCount = new BigDecimal(deptnoMapper.findTotalCount());
        log.info("查询总数为: "+totalCount);
        BigDecimal deptCount = new BigDecimal(deptnoMapper.findDeptCount(deptno));
        log.info("查询deptno数量为: "+deptCount);
        BigDecimal per = deptCount.divide(totalCount,2, RoundingMode.HALF_UP);
        log.info("deptno为: "+deptno,"部门占比为: "+per);
        outVo.setDeptnoPercent(""+per);
        return outVo;
    }

    @Override
    public A0006Response getList(A0004Request request) {
        A0006Response outVo = new A0006Response();
        DeptBo deptBo = new DeptBo();
        if (null != request){
            BeanUtils.copyProperties(request,deptBo);
        }
        List<Dept> deptList=deptnoMapper.getList(deptBo);
        outVo.setDeptList(deptList);
        return outVo;
    }
}
