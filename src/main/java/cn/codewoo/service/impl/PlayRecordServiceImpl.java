package cn.codewoo.service.impl;

import cn.codewoo.entity.PlayRecord;
import cn.codewoo.mapper.PlayRecordMapper;
import cn.codewoo.service.IPlayRecordService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author kehong
 * 添加播放记录
 */
public class PlayRecordServiceImpl implements IPlayRecordService {

    @Autowired(required = false)
    private PlayRecordMapper playRecordMapper;
    @Override
    public int save(PlayRecord playRecord) {
        int rows = playRecordMapper.save(playRecord);
        return rows;
    }
}
