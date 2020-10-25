package cn.codewoo.service.impl;

import cn.codewoo.entity.Episode;
import cn.codewoo.entity.PlayRecord;
import cn.codewoo.entity.Video;
import cn.codewoo.entity.VideoOrder;
import cn.codewoo.exception.BusinessException;
import cn.codewoo.mapper.EpisodeMapper;
import cn.codewoo.mapper.PlayRecordMapper;
import cn.codewoo.mapper.VideoMapper;
import cn.codewoo.mapper.VideoOrderMapper;
import cn.codewoo.service.IVideoOrderService;
import cn.codewoo.utils.BaseRespCodeImpl;
import cn.codewoo.vo.req.VideoOrderSaveReqVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author kehong
 */
@Service
public class VideoOrderServiceImpl implements IVideoOrderService {
    @Autowired(required = false)
    private VideoOrderMapper videoOrderMapper;
    @Autowired(required = false)
    private VideoMapper videoMapper;
    @Autowired(required = false)
    private PlayRecordMapper playRecordMapper;
    @Autowired(required = false)
    private EpisodeMapper episodeMapper;

    @Override
    @Transactional
    public VideoOrder save(Integer userId, VideoOrderSaveReqVO vo) {
        //判断选择的课程是否存在
        Video video = videoMapper.selectVideoById(vo.getVideoId());
        if (video == null){
            throw new BusinessException(BaseRespCodeImpl.VIDEO_NOT_EXISTS);
        }

        //获取是否已经购买过该课程
        VideoOrder videoOrder = videoOrderMapper.selectVideoOrderByUserIdAndVideoId(userId, vo.getVideoId(), 1);
        if (videoOrder != null){
            throw new BusinessException(BaseRespCodeImpl.VIDEO_ORDER_NOT_EXISTS);
        }

        //构建订单信息
        VideoOrder newVideoOrder = new VideoOrder();
        newVideoOrder.setCreateTime(new Date());
        newVideoOrder.setOutTradeNo(UUID.randomUUID().toString());
        newVideoOrder.setState(1);
        newVideoOrder.setTotalFee(video.getPrice());
        newVideoOrder.setVideoImg(video.getCoverImg());
        newVideoOrder.setVideoTitle(video.getTitle());
        newVideoOrder.setUserId(userId);
        newVideoOrder.setVideoId(video.getId());
        int rows = videoOrderMapper.save(newVideoOrder);
        //!=1下单失败
        if (rows != 1){
            throw new BusinessException(BaseRespCodeImpl.ERROR);
        }


        //购买成功后，添加播放记录为第一集
        //查询出购买视频的第一集信息
        Episode episode = episodeMapper.selectFirstByVideoId(video.getId());
        //构建播放记录信息
        PlayRecord playRecord = new PlayRecord();
        playRecord.setUserId(userId);
        playRecord.setVideoId(video.getId());
        playRecord.setEpisodeId(episode.getId());
        playRecord.setCurrentNum(episode.getNum());
        playRecord.setCreateTime(new Date());
        int result = playRecordMapper.save(playRecord);
        if (result != 1){
            throw new BusinessException(BaseRespCodeImpl.PLAY_RECORD_SAVE_ERROR);
        }

        return newVideoOrder;
    }

    @Override
    public List<VideoOrder> selectOrderListByUserId(Integer userId) {
        return videoOrderMapper.selectOrderListByUserId(userId);
    }
}
