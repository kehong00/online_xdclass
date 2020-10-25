package cn.codewoo.mapper;

import cn.codewoo.entity.Episode;

/**
 * @author kehong
 * 视频集mapper
 */
public interface EpisodeMapper {
    /**
     * 根据视频id查询视频第一集信息
     * @param videoId
     * @return
     */
    Episode selectFirstByVideoId(Integer videoId);
}
