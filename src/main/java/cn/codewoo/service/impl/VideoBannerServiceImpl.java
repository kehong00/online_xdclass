package cn.codewoo.service.impl;

import cn.codewoo.constant.CacheKey;
import cn.codewoo.entity.VideoBanner;
import cn.codewoo.mapper.VideoBannerMapper;
import cn.codewoo.service.IVideoBannerService;
import cn.codewoo.utils.BaseCache;
import cn.codewoo.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class VideoBannerServiceImpl implements IVideoBannerService {
    @Autowired(required = false)
    private VideoBannerMapper videoBannerMapper;
    @Autowired
    private BaseCache baseCache;
    @Override
    public DataResult list() {
        try {
            Object cacheObj = baseCache.getTenMinuteCache().get(CacheKey.INDEX_BANNER_LIST,()->{
                return videoBannerMapper.list();
            });
            if (cacheObj instanceof List){
                List<VideoBanner> result = (List<VideoBanner>) cacheObj;
                return DataResult.success(result);
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
