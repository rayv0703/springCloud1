package com.broada.two.data.repo;

import com.broada.two.data.domain.EmpInf;
import org.springframework.data.repository.CrudRepository;

public interface EmpRepository extends CrudRepository<EmpInf,Integer> {
}
