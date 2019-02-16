package com.broada.two.data.outbound;

import com.broada.cm.api.mybatis1.StudentInf;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "rayv-mybatis",url = "localhost:9000")
public interface OutStudentInf extends StudentInf {
}
