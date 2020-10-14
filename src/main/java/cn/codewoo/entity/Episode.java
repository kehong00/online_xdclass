package cn.codewoo.entity;

/**
 * @author kehong
 */

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
public class Episode {
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("集标题")
    private String title;
    @ApiModelProperty("第几集，整个视频")
    private Integer num;
    @ApiModelProperty("顺序，章节里的顺序")
    private Integer ordered;
    @ApiModelProperty("播放地址")
    private String playUrl;
    @ApiModelProperty("章节组件")
    private Integer chapterId;
    @ApiModelProperty("是否是付费章节")
    private Integer free;
    @ApiModelProperty("所属视频id")
    private Integer videoId;
    @ApiModelProperty("创建时间")
    private Date createTime;

    @Override
    public String toString() {
        return "Episode{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", num=" + num +
                ", ordered=" + ordered +
                ", playUrl='" + playUrl + '\'' +
                ", chapterId=" + chapterId +
                ", free=" + free +
                ", videoId=" + videoId +
                ", createTime=" + createTime +
                '}';
    }

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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public Integer getFree() {
        return free;
    }

    public void setFree(Integer free) {
        this.free = free;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
