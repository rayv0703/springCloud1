package com.broada.two.controller;

import com.broada.two.data.domain.Chat02Bo;
import com.broada.two.data.domain.ChatBo;
import com.broada.two.data.domain.HotQuestion;
import com.broada.two.data.vo.request.A00001_Request;
import com.broada.two.data.vo.response.A000011_ResponseVo;
import com.broada.two.data.vo.response.A000012_ResponseVo;
import com.broada.two.data.vo.response.A00001_ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Api(value = "外呼机器人测试接口",tags = {"测试外呼机器人数据"})
@RestController
@RequestMapping("/two")
public class RobotController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/chat",method = RequestMethod.POST)
    @ApiOperation(value = "外呼机器人问答接口")
    public A00001_ResponseVo chat(@RequestBody  A00001_Request request){
        A00001_ResponseVo responseVo = new A00001_ResponseVo();
        String url = null;
        if (StringUtils.isNotEmpty(request.getQuestionId())) {
            url = "http://127.0.0.1:9001/two/testNum";
            A000011_ResponseVo vo = restTemplate.postForObject(url, request, A000011_ResponseVo.class);
            BeanUtils.copyProperties(vo,responseVo);
        }else {
            url = "http://127.0.0.1:9001/two/testWord";
            A000012_ResponseVo vo = restTemplate.postForObject(url, request, A000012_ResponseVo.class);
            BeanUtils.copyProperties(vo,responseVo);
        }
        //BeanUtils.copyProperties(vo,responseVo);
        return responseVo;
    }

    @RequestMapping(value = "/testNum",method = RequestMethod.POST)
    @ApiOperation(value = "测试问句")
    public A00001_ResponseVo testWord(@RequestBody A00001_Request request){
        A00001_ResponseVo responseVo = new A00001_ResponseVo();
        //如果QUESTION_ID为空,走word
        if (StringUtils.isEmpty(request.getQuestionId())) {
            A000011_ResponseVo res = createResponse01();
            ChatBo msgEntity = res.getMsgEntity();
            responseVo.setMsgEntity(msgEntity);
        }
        return responseVo;
    }

    @RequestMapping(value = "/testWord",method = RequestMethod.POST)
    @ApiOperation(value = "测试编号到答案")
    public A00001_ResponseVo testNum(@RequestBody A00001_Request request){
        A00001_ResponseVo responseVo = new A00001_ResponseVo();
        if (StringUtils.isNotEmpty(request.getQuestionId())){
            A000012_ResponseVo res = createResponse02();
            Chat02Bo msgEntity = res.getMsgEntity();
            BeanUtils.copyProperties(res,responseVo);
            //responseVo.setMsgEntity(msgEntity);
        }
        return responseVo;
    }

    /**
     * 问句制作回答
     * @return
     */
    private A000011_ResponseVo createResponse01(){
        A000011_ResponseVo vo = new A000011_ResponseVo();
        ChatBo bo = new ChatBo();
        bo.setResultType("02");
        List<HotQuestion> questionList = new ArrayList<HotQuestion>();
        HotQuestion q1 = new HotQuestion("Q00000085018", "自主就业的退役士兵前有工作单位,退役后还可以回原单位码?");
        HotQuestion q2 = new HotQuestion("Q00000085007", "士兵退役后的安置方式");
        questionList.add(q1);
        questionList.add(q2);
        bo.setQuestionList(questionList);
        vo.setMsgEntity(bo);
        return vo;
    }

    /**
     * 编号直接查答案
     * @return
     */
    private A000012_ResponseVo createResponse02(){
        A000012_ResponseVo vo = new A000012_ResponseVo();
        //ChatBo bo = new ChatBo();
        Chat02Bo bo = new Chat02Bo();
        bo.setQuestionName("自主就业的退役士兵入伍前有工作单位,退役后还可以回原单位吗?");
        bo.setQuestionId("Q00000085018");
        bo.setResultType("01");
        bo.setStandardAnswer("自主就业的退役士兵入伍前是国家机关、社会团体、事业单位工作人员或者职工的，退出现役后可以选择复职复工，其工资、福利和其他待遇不得低于本单位同等条件人员的平均水平。");
        vo.setMsgEntity(bo);
        return vo;
    }
}
