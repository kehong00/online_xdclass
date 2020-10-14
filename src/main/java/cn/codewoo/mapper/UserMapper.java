package cn.codewoo.mapper;

import cn.codewoo.entity.User;

/**
 * @author kehong
 * 用户表mapper
 */
public interface UserMapper {
    /**
     * 新增用户
     * @param user
     * @return
     */
    int save(User user);
}
