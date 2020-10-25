package cn.codewoo.service.impl;

import cn.codewoo.constant.CacheKey;
import cn.codewoo.entity.Video;
import cn.codewoo.mapper.VideoMapper;
import cn.codewoo.service.IVideoService;
import cn.codewoo.utils.BaseCache;
import cn.codewoo.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author kehong
 */
@Service
public class VideoServiceImpl implements IVideoService {
    @Autowired(required = false)
    private VideoMapper videoMapper;
    @Autowired
    private BaseCache baseCache;
    @Override
    public DataResult list() {
        return DataResult.success(videoMapper.list());
    }

    @Override
    public DataResult getList() {
        try{
            Object cacheObj = baseCache.getTenMinuteCache().get(CacheKey.INDEX_VIDEO_LIST,()->{
                return videoMapper.list();
            });
            if (cacheObj instanceof List){
                List<Video> result = (List<Video>) cacheObj;
                return DataResult.success(result);
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public DataResult selectVideoDetailById(Integer videoId) {
        try{
            String videoCacheKey = String.format(CacheKey.VIDEO_DETAIL,videoId);
            Object cacheObj = baseCache.getOneHourCache().get(videoCacheKey, () -> {
                return videoMapper.selectVideoDetailById(videoId);
            });
            if (cacheObj instanceof Video){
                Video video = (Video) cacheObj;
                return DataResult.success(video);
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }


}
