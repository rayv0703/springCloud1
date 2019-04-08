package com.broada.three.data.mapper;

import com.broada.three.data.domain.Emp;
import com.broada.three.data.domain.EmpBo;
import com.broada.three.data.domain.EmpDetail;
import com.broada.three.data.vo.response.A0002Response;
import org.springframework.stereotype.Component;

import java.util.List;
//@Component
public interface EmpMapper {

    List<Emp> getEmpDetail(Emp emp);

    List<Emp> getList();

    List<Emp> searchEmpList(EmpBo bo);

    int addEmpInf(Emp emp);

    int updateEmpInf(Emp emp);

    void deleteEmpInf(Integer empno);

    A0002Response findByIds(List<Integer> ids);

    List<EmpDetail> findList();
}
