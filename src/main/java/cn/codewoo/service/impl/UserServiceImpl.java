package cn.codewoo.service.impl;

import cn.codewoo.entity.User;
import cn.codewoo.exception.BusinessException;
import cn.codewoo.mapper.UserMapper;
import cn.codewoo.service.IUserService;
import cn.codewoo.utils.BaseRespCodeImpl;
import cn.codewoo.utils.CommonUtils;
import cn.codewoo.utils.IBaseRespCode;
import cn.codewoo.utils.JWTUtils;
import cn.codewoo.vo.req.UserLoginReqVO;
import cn.codewoo.vo.req.UserRegisterReqVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public User register(UserRegisterReqVO vo) {
        User user = new User();
        BeanUtils.copyProperties(vo,user);
        user.setPwd(CommonUtils.MD5(user.getPwd()));
        user.setCreateTime(new Date());
        user.setHeadImg("111111");
        int result = userMapper.save(user);
        if (result != 1){
            throw new BusinessException(BaseRespCodeImpl.USER_REG_ERROR);
        }
        return user;
    }

    @Override
    public String login(UserLoginReqVO vo) {
        User user = userMapper.selectUserByName(vo.getName());
        if (user == null){
            throw new BusinessException(BaseRespCodeImpl.USER_LOGIN_NOT_FOUNT);
        }
        if (!user.getPwd().equals(CommonUtils.MD5(vo.getPwd()))){
            throw new BusinessException(BaseRespCodeImpl.USER_LOGIN_PWD_ERROR);
        }
        return JWTUtils.geneJsonWebToken(user);
    }

    @Override
    public User getUserInfoByToken(String token) {
        Integer id = JWTUtils.getId(token);
        return userMapper.selectUserById(id);
    }
}
