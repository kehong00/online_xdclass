package cn.codewoo.mapper;

import cn.codewoo.entity.VideoBanner;

import java.util.List;

/**
 * @author kehong
 * 轮播图相关mapper接口
 */
public interface VideoBannerMapper {
    /**
     * @return
     * 获取所有轮播图记录，
     */
    List<VideoBanner> list();
}
