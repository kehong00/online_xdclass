package cn.codewoo.service.impl;

import cn.codewoo.mapper.VideoBannerMapper;
import cn.codewoo.service.IVideoBannerService;
import cn.codewoo.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoBannerServiceImpl implements IVideoBannerService {
    @Autowired
    private VideoBannerMapper videoBannerMapper;
    @Override
    public DataResult list() {
        return DataResult.success(videoBannerMapper.list());
    }
}
