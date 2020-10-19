package cn.codewoo.service;

import cn.codewoo.entity.User;
import cn.codewoo.vo.req.UserLoginReqVO;
import cn.codewoo.vo.req.UserRegisterReqVO;

/**
 * @author kehong
 * 用户相关服务层
 */
public interface IUserService {
    /**
     * 用户注册功能接口
     * @param vo
     * @return
     */
    User register(UserRegisterReqVO vo);

    /**
     * 用户登录接口
     * @param vo
     * @return
     */
    String login(UserLoginReqVO vo);

    /**
     * 根据token中的用户id获取用户信息
     * @param token
     * @return
     */
    User getUserInfoByToken(String token);
}
