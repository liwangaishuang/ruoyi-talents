package com.ruoyi.talents.service;

import java.util.List;
import com.ruoyi.talents.domain.User;

/**
 * 用户Service接口
 *
 * @author ruoyi
 * @date 2021-06-11
 */
public interface IUserService
{
    /**
     * 查询用户
     *
     * @param id 用户ID
     * @return 用户
     */
    public User selectUserById(String id);

    /**
     * 查询用户列表
     *
     * @param user 用户
     * @return 用户集合
     */
    public List<User> selectUserList(User user);

    /**
     * 新增用户
     *
     * @param user 用户
     * @return 结果
     */
    public int insertUser(User user);

    /**
     * 修改用户
     *
     * @param user 用户
     * @return 结果
     */
    public int updateUser(User user);

    /**
     * 批量删除用户
     *
     * @param ids 需要删除的用户ID
     * @return 结果
     */
    public int deleteUserByIds(String[] ids);

    /**
     * 删除用户信息
     *
     * @param id 用户ID
     * @return 结果
     */
    public int deleteUserById(String id);
}
