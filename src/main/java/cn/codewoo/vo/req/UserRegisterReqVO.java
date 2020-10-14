package cn.codewoo.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author kehong
 * 用户注册请求数据VO
 */
@ApiModel(description = "用户注册VO")
public class UserRegisterReqVO {
    @ApiModelProperty("用户名")
    private String name;
    @ApiModelProperty("密码")
    private String pwd;
    @ApiModelProperty("手机号")
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserRegisterReqVO{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
