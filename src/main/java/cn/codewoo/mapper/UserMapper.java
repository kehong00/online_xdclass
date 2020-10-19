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

    /**
     * 根据用户名查询用户
     * @param name
     * @return
     */
    User selectUserByName(String name);

    /**
     * 根据手机号查询用户
     * @param phone
     * @return
     */
    User selectUserByPhone(String phone);

    /**
     * 根据id查询用户
     * @Integer
     * @return
     */
    User selectUserById(Integer id);
}
