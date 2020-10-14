package cn.codewoo.service;

import cn.codewoo.utils.DataResult;

/**
 * @author kehong
 * 视频服务层
 */
public interface IVideoService {
    /**
     * 获取所有视频记录
     * @return
     */
    DataResult list();

    /**
     * 测试用的
     * @return
     */
    Object getList();

    /**
     * 根据视频id获取视频详情
     * @param videoId
     * @return
     */
    DataResult selectVideoDetailById(Integer videoId);
}
