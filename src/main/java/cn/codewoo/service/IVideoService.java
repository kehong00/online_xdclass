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

    Object getList();
}
