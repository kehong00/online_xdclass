package cn.codewoo.entity;

/**
 * @author kehong
 * 视频实体类
 */

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
public class Video {
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("视频标题")
    private String title;
    @ApiModelProperty("视频概述")
    private String summary;
    @ApiModelProperty("封面图片")
    private String coverImg;
    @ApiModelProperty("价格，单位：分")
    private Integer price;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("评分")
    private Double point;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", coverImg='" + coverImg + '\'' +
                ", price=" + price +
                ", createTime=" + createTime +
                ", point=" + point +
                '}';
    }
}
