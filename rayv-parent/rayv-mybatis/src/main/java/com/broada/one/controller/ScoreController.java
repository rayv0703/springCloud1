package com.broada.one.controller;

import com.broada.one.data.domain.Score;
import com.broada.one.data.domain.ScoreDetail;
import com.broada.one.service.ScoreService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(value = "得分查询",tags = {"得分查询"})
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @RequestMapping(value = "/one/findAll",method = RequestMethod.GET)
    @ApiOperation(value = "查询所有分数",notes = "查询所有分数")
    public List<ScoreDetail> findAll(){
        Page<ScoreDetail> pages = PageHelper.startPage(0, 4);
        List<ScoreDetail> list = scoreService.findAll();
        return list;
    }
    @ApiOperation(value = "得分查询",notes = "")
    @RequestMapping(value = "/one/queryDetail",method = RequestMethod.POST)
    public List<ScoreDetail> queryDetail(@ApiParam(name = "score",value = "得分实体",required = true)@RequestBody @Valid Score score){
        return scoreService.queryDetail(score);
    }
}
