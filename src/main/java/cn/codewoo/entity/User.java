package cn.codewoo.entity;

/**
 * @author kehong
 * 用户表实体类
 */


import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
public class User {
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("昵称")
    private String name;

    @ApiModelProperty("密码")
    private String pwd;
    @ApiModelProperty("头像")
    private String headImg;
    @ApiModelProperty("手机号")
    private String phone;
    @ApiModelProperty("创建时间")
    private Date createTime;
}
