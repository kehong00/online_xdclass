package cn.codewoo.entity;

/**
 * @author kehong
 * 视频订单实体类
 */

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
public class VideoOrder {
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("订单唯一标识")
    private String outTradeNo;
    @ApiModelProperty("订单状态：0表示未支付，1表示已支付")
    private Integer state;
    @ApiModelProperty("订单生成时间")
    private Date createTime;
    @ApiModelProperty("支付金额，单位：分")
    private Integer totalFee;
    @ApiModelProperty("视频主键")
    private Integer videoId;
    @ApiModelProperty("视频标题")
    private String videoTitle;
    @ApiModelProperty("视频图片")
    private String videoImage;
    @ApiModelProperty("用户id")
    private Integer userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getVideoImage() {
        return videoImage;
    }

    public void setVideoImage(String videoImage) {
        this.videoImage = videoImage;
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
                ", videoImage='" + videoImage + '\'' +
                ", userId=" + userId +
                '}';
    }
}
