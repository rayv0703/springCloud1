package com.broada.cm.utils;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * List拷贝util
 */
public class CopyListUtil {
    /**
     * copyTo:List拷贝,浅拷贝,只拷贝一层
     * @param source
     * @param destinationClass
     * @param <E>
     * @return
     * @throws Exception
     */
    public static <E> List<E> copyTo(List<?> source,Class<E> destinationClass)throws Exception{
        if (source.size()==0) return Collections.emptyList();
        ArrayList<E> res = new ArrayList<E>(source.size());
        for (Object o : source) {
            E e = destinationClass.newInstance();
            BeanUtils.copyProperties(o,e);
            res.add(e);
        }
        return res;
    }
}
