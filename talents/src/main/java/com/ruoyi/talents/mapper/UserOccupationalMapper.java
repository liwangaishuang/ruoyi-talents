package com.ruoyi.talents.mapper;

import java.util.List;
import com.ruoyi.talents.domain.UserOccupational;

/**
 * 用户职业资格Mapper接口
 * 
 * @author ruoyi
 * @date 2021-06-26
 */
public interface UserOccupationalMapper 
{
    /**
     * 查询用户职业资格
     * 
     * @param id 用户职业资格ID
     * @return 用户职业资格
     */
    public List<UserOccupational> selectUserOccupationalById(Long id);

    /**
     * 查询用户职业资格列表
     * 
     * @param userOccupational 用户职业资格
     * @return 用户职业资格集合
     */
    public List<UserOccupational> selectUserOccupationalList(UserOccupational userOccupational);

    /**
     * 新增用户职业资格
     * 
     * @param userOccupational 用户职业资格
     * @return 结果
     */
    public int insertUserOccupational(UserOccupational userOccupational);

    /**
     * 修改用户职业资格
     * 
     * @param userOccupational 用户职业资格
     * @return 结果
     */
    public int updateUserOccupational(UserOccupational userOccupational);

    /**
     * 删除用户职业资格
     *
     * @param id 用户职业资格ID
     * @return 结果
     */
    public int deleteUserOccupationalById(Long id);

    /**
     * 批量删除用户职业资格
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserOccupationalByIds(Long[] ids);

    /**
     * 根据userId删除用户职业资格
     *
     * @param id 用户职业资格ID
     * @return 结果
     */
    public int deleteUserOccupationalByUserId(Long id);

    /**
     * 根据userId批量删除用户职业资格
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserOccupationalByUserIds(Long[] ids);
}
