package cn.codewoo.mapper;

import cn.codewoo.entity.PlayRecord;

/**
 * @author kehong
 * 视频播放记录mapper
 */
public interface PlayRecordMapper {
    /**
     * 新增播放记录
     * @param playRecord
     * @return
     */
    int save(PlayRecord playRecord);
}
