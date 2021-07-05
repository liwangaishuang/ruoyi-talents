package com.ruoyi.talents.mapper;

import java.util.Date;
import java.util.List;
import com.ruoyi.talents.domain.User;
import com.ruoyi.talents.domain.dto.UserDto;
import org.apache.ibatis.annotations.Param;

/**
 * 用户Mapper接口
 *
 * @author ruoyi
 * @date 2021-06-11
 */
public interface UserMapper
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

    public List<User> selectSpecialistList(User user);

    public List<User> selectRemoveList(User user);

    public List<User> selectExamineList(User user);

    public List<UserDto> selectRegisteredList(UserDto userDto);

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

    public int editPassword(@Param(value = "userId") String userId,@Param(value = "password") String password,@Param(value = "updateTime") Date updateTime);

    /**
     * 删除用户
     *
     * @param id 用户ID
     * @return 结果
     */
    public int deleteUserById(Long id);

    /**
     * 批量删除用户
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserByIds(Long[] ids);
}
