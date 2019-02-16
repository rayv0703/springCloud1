package com.broada.one.service.impl;

import com.broada.one.data.domain.Score;
import com.broada.one.data.domain.ScoreDetail;
import com.broada.one.data.mapper.ScoreMapper;
import com.broada.one.service.ScoreService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;
@Service
@Transactional
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    ScoreMapper scoreMapper;
    @Override
    public List<ScoreDetail> findAll() {
        return scoreMapper.findAll();
    }

    @Override
    public List<ScoreDetail> queryDetail(@Valid Score s) {
        Score score = new Score();
        BeanUtils.copyProperties(s,score);
        return scoreMapper.queryDetail(score);
    }
}
