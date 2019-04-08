package com.broada.three.data.mapper;

import com.broada.three.data.domain.Dept;
import com.broada.three.data.domain.DeptBo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DeptnoMapper {

    @Select("select * from dept where deptno = #{deptno}")
    @Results(id = "deptnoMap",
            value = {
                    @Result(id = true, column = "DEPTNO", property = "deptno"),
                    @Result(column = "DNAME", property = "dname"),
                    @Result(column = "LOC",property = "loc")
            })
    Dept findOne(@Param("deptno") Integer deptno);

    @Select("select * from dept")
    @ResultMap("deptnoMap")
    List<Dept> findList();

    @Select("select count(1) from emp")
    @ResultType(Integer.class)
    Integer findTotalCount();

    @Select("select count(1) from emp e where e.deptno = #{deptno}")
    @ResultType(Integer.class)
    Integer findDeptCount(@Param("deptno") Integer deptno);

    List<Dept> getList(DeptBo deptBo);

    Dept findByDeptno(@Param("deptno")Integer deptno);
}
