package cn.codewoo.controller;

import cn.codewoo.constant.Constants;
import cn.codewoo.service.IUserService;
import cn.codewoo.utils.DataResult;
import cn.codewoo.vo.req.UserLoginReqVO;
import cn.codewoo.vo.req.UserRegisterReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kehong
 */
@RestController
@RequestMapping("/api/v1/pri/user")
@Api(tags = "用户相关接口")
public class UserController {
    @Autowired
    private IUserService userService;

    @ApiOperation("用户注册接口")
    @PostMapping("/register")
    public DataResult register(@RequestBody UserRegisterReqVO vo){
        return DataResult.success(userService.register(vo));
    }

    @ApiOperation("用户登录接口")
    @PostMapping("/login")
    public DataResult login(@RequestBody UserLoginReqVO vo){
        return DataResult.success(userService.login(vo));
    }

    @ApiOperation("测试")
    @GetMapping("/test")
    public DataResult test(){
        return DataResult.success("test");
    }

    @ApiOperation("根据token查询用户信息")
    @GetMapping("/info")
    public DataResult userInfo(HttpServletRequest request){
        String token = request.getHeader(Constants.AUTHENTICATED_TOKEN.toString());
        return DataResult.success(userService.getUserInfoByToken(token));
    }
    
}
