package com.broada.one.service;

import com.broada.one.data.domain.Score;
import com.broada.one.data.domain.ScoreDetail;

import javax.validation.Valid;
import java.util.List;

public interface ScoreService {


    List<ScoreDetail> findAll();

    List<ScoreDetail> queryDetail(@Valid Score score);
}
