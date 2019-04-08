package com.broada.three.service.inf;

import com.broada.three.data.vo.request.A0004Request;
import com.broada.three.data.vo.response.A0005Response;
import com.broada.three.data.vo.response.A0006Response;
import com.broada.three.data.vo.response.A0007Response;

public interface DeptnoService {
    A0005Response findOne(Integer deptno);

    A0006Response findList();

    A0007Response findPercent(Integer deptno);

    A0006Response getList(A0004Request request);
}
