package com.broada.three.service.inf;

import com.broada.three.data.vo.request.A0001Request;
import com.broada.three.data.vo.request.A0003Request;
import com.broada.three.data.vo.response.*;

import java.util.List;

public interface EmpService {
    A0001Response getEmpDetail(A0001Request request);

    A0002Response getList();

    A0003Response searchEmpList(A0003Request request);

    A0004Response addEmpInf(A0001Request request);

    A0004Response updateEmpInf(A0001Request request);

    A0004Response deleteEmpInf(Integer empno);

    A0002Response findByIds(List<Integer> ids);

    A0008Response findList();
}
