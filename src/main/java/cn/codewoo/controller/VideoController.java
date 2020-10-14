package cn.codewoo.controller;

import cn.codewoo.service.IVideoBannerService;
import cn.codewoo.service.IVideoService;
import cn.codewoo.utils.DataResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation("获取视频列表")
    @GetMapping("/pub/list")
    public DataResult videoList(){
        return videoService.list();
    }

    @ApiOperation("获取轮播图")
    @GetMapping("/pub/banners")
    public DataResult videoBanners(){
        return videoBannerService.list();
    }

    @ApiOperation("test")
    @GetMapping("/put/getList")
    public Object videoList_test(){
        return videoService.getList();
    }

    @ApiOperation(("根据视频id获取视频详情"))
    @GetMapping("/put/video")
    public DataResult getVideo(@RequestParam(value = "videoId",required = true) Integer videoId){
        return videoService.selectVideoDetailById(videoId);
    }


}
