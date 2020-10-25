package cn.codewoo.service;

import cn.codewoo.entity.PlayRecord;

/**
 * @author kehong
 * 视频播放记录服务层
 */
public interface IPlayRecordService {
    /**
     * 新增播放记录
     * @param playRecord
     * @return
     */
    int save(PlayRecord playRecord);
}
