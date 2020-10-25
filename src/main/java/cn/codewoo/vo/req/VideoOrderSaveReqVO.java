package cn.codewoo.vo.req;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author kehong
 * 视频订单
 */
public class VideoOrderSaveReqVO {
    @JsonProperty("video_id")
    private Integer videoId;

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    @Override
    public String toString() {
        return "VideoOrderSaveReqVO{" +
                "videoId=" + videoId +
                '}';
    }
}
