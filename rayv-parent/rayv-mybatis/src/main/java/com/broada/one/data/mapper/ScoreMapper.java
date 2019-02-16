package com.broada.one.data.mapper;


import com.broada.one.data.domain.Score;
import com.broada.one.data.domain.ScoreDetail;

import java.util.List;

public interface ScoreMapper {

    List<ScoreDetail> findAll();

    List<ScoreDetail> queryDetail(Score score);
}