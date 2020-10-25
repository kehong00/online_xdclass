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

    /**
     * 根据视频id查询视频详情，包含章节信息，章节中的集数信息
     * @param videoId
     * @return
     */
    Video selectVideoDetailById(Integer videoId);

    /**
     * 根据视频id，查询视频信息
     * @param videoId
     * @return
     */
    Video selectVideoById(Integer videoId);
}
