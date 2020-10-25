package cn.codewoo.controller;

import cn.codewoo.constant.Constants;
import cn.codewoo.entity.VideoOrder;
import cn.codewoo.service.IVideoOrderService;
import cn.codewoo.service.impl.VideoOrderServiceImpl;
import cn.codewoo.utils.DataResult;
import cn.codewoo.utils.JWTUtils;
import cn.codewoo.vo.req.VideoOrderSaveReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kehong
 * 视频订单控制层
 */
@RequestMapping("/api/pri/order")
@Api(tags = "视频订单控制层")
@RestController
public class VideoOrderController {

    @Autowired
    private IVideoOrderService videoOrderService;

    @ApiOperation("订购视频接口")
    @PostMapping("/save")
    public DataResult saveOrder(HttpServletRequest request, @RequestBody VideoOrderSaveReqVO vo){
        String token = request.getHeader(Constants.AUTHENTICATED_TOKEN.toString());
        Integer userId = JWTUtils.getId(token);
        VideoOrder result = videoOrderService.save(userId, vo);
        return DataResult.success(result);
    }

    @GetMapping("/list")
    @ApiOperation("视频订单列表")
    public DataResult videoOrderList(HttpServletRequest request){
        String token = request.getHeader(Constants.AUTHENTICATED_TOKEN.toString());
        Integer userId = JWTUtils.getId(token);
        return DataResult.success(videoOrderService.selectOrderListByUserId(userId));
    }
}
