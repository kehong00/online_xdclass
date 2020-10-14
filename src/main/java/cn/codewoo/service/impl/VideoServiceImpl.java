package cn.codewoo.service.impl;

import cn.codewoo.mapper.VideoMapper;
import cn.codewoo.service.IVideoService;
import cn.codewoo.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kehong
 */
@Service
public class VideoServiceImpl implements IVideoService {
    @Autowired(required = false)
    private VideoMapper videoMapper;
    @Override
    public DataResult list() {
        return DataResult.success(videoMapper.list());
    }

    @Override
    public Object getList() {
        return videoMapper.list();
    }

    @Override
    public DataResult selectVideoDetailById(Integer videoId) {
        return DataResult.success(videoMapper.selectVideoDetailById(videoId));
    }


}
