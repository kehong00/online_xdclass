package cn.codewoo.mapper;

import cn.codewoo.entity.VideoOrder;

import java.util.List;

/**
 * @author kehong
 * 视频订单mapper
 */
public interface VideoOrderMapper {
    /**
     * 根据用户id，视频id，订单状态查询订单
     * @param userId
     * @param videoId
     * @param state
     * @return
     */
    VideoOrder selectVideoOrderByUserIdAndVideoId(Integer userId,Integer videoId,Integer state);

    /**
     * 新增
     * @param videoOrder
     * @return
     */
    int save(VideoOrder videoOrder);

    /**
     * 根据用户id查询视频订单列表
     * @param userId
     * @return
     */
    List<VideoOrder> selectOrderListByUserId(Integer userId);
}
