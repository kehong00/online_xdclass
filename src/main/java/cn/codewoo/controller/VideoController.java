package cn.codewoo.controller;

import cn.codewoo.constant.CacheKey;
import cn.codewoo.constant.Constants;
import cn.codewoo.service.IVideoBannerService;
import cn.codewoo.service.IVideoService;
import cn.codewoo.utils.BaseCache;
import cn.codewoo.utils.DataResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

/**
 * @author kehong
 */

@Api(tags = "视频相关接口")
@RestController
@RequestMapping("/api/v1")
public class VideoController {
    @Autowired
    private IVideoService videoService;
    @Autowired
    private IVideoBannerService videoBannerService;

    @Autowired
    private BaseCache baseCache;

    @ApiOperation("获取视频列表")
    @GetMapping("/pub/list")
    public DataResult videoList(){
        return videoService.getList();
    }

    @ApiOperation("获取轮播图")
    @GetMapping("/pub/banners")
    public DataResult videoBanners(){
        return videoBannerService.list();
    }

    @ApiOperation("test")
    @GetMapping("/pub/getList")
    public Object videoList_test(){
        return videoService.getList();
    }

    @ApiOperation(("根据视频id获取视频详情"))
    @GetMapping("/pub/video")
    public DataResult getVideo(@RequestParam(value = "video_id",required = true) Integer videoId){

        return videoService.selectVideoDetailById(videoId);
    }


}
