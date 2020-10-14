package cn.codewoo.mapper;

import cn.codewoo.entity.Video;

import java.util.List;

/**
 * @author kehong
 * 视频相关mapper接口
 */
public interface VideoMapper {
    /**
     * 获取视频记录
     * @return
     */
    List<Video> list();
}
