package cn.codewoo.service;

import cn.codewoo.entity.Video;
import cn.codewoo.entity.VideoOrder;
import cn.codewoo.vo.req.VideoOrderSaveReqVO;

import java.util.List;

/**
 * @author kehong
 * 视频订单服务层
 */
public interface IVideoOrderService {
    /**
     * 新增订单，购买成功后会添加播放记录为视频第一集
     * @param userId
     * @param vo
     * @return
     */
    VideoOrder save(Integer userId, VideoOrderSaveReqVO vo);

    /**
     * 根据用户id查询订单列表
     * @param userId
     * @return
     */
    List<VideoOrder> selectOrderListByUserId(Integer userId);

}
