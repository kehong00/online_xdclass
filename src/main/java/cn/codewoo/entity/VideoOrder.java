package cn.codewoo.entity;

/**
 * @author kehong
 * 视频订单实体类
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
public class VideoOrder {
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("订单唯一标识")
    @JsonProperty("out_trade_no")
    private String outTradeNo;
    @ApiModelProperty("订单状态：0表示未支付，1表示已支付")
    private Integer state;
    @ApiModelProperty("订单生成时间")
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @ApiModelProperty("支付金额，单位：分")
    @JsonProperty("total_fee")
    private Integer totalFee;
    @ApiModelProperty("视频主键")
    @JsonProperty("video_id")
    private Integer videoId;
    @ApiModelProperty("视频标题")
    @JsonProperty("video_title")
    private String videoTitle;
    @ApiModelProperty("视频图片")
    @JsonProperty("video_img")
    private String videoImg;
    @ApiModelProperty("用户id")
    @JsonProperty("user_id")
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void Integer(Integer id) {
        this.id = id;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoImg() {
        return videoImg;
    }

    public void setVideoImg(String videoImg) {
        this.videoImg = videoImg;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "VideoOrder{" +
                "id='" + id + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", state=" + state +
                ", createTime=" + createTime +
                ", totalFee=" + totalFee +
                ", videoId=" + videoId +
                ", videoTitle='" + videoTitle + '\'' +
                ", videoImg='" + videoImg + '\'' +
                ", userId=" + userId +
                '}';
    }
}
