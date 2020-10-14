package cn.codewoo.entity;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
/**
 * @author kehong
 * 章节实体类
 */
public class Chapter {
    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("视频主键")
    private Integer videoId;

    @ApiModelProperty("章节名称")
    private String title;

    @ApiModelProperty("章节顺序")
    private Integer ordered;

    @ApiModelProperty("创建时间")
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", videoId=" + videoId +
                ", title='" + title + '\'' +
                ", ordered=" + ordered +
                ", createTime=" + createTime +
                '}';
    }
}
