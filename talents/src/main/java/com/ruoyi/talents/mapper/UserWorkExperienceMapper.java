package com.ruoyi.talents.mapper;

import java.util.List;
import com.ruoyi.talents.domain.UserWorkExperience;

/**
 * 用户工作经历Mapper接口
 * 
 * @author ruoyi
 * @date 2021-06-26
 */
public interface UserWorkExperienceMapper 
{
    /**
     * 查询用户工作经历
     * 
     * @param id 用户工作经历ID
     * @return 用户工作经历
     */
    public UserWorkExperience selectUserWorkExperienceById(Long id);

    /**
     * 查询用户工作经历列表
     * 
     * @param userWorkExperience 用户工作经历
     * @return 用户工作经历集合
     */
    public List<UserWorkExperience> selectUserWorkExperienceList(UserWorkExperience userWorkExperience);

    /**
     * 新增用户工作经历
     * 
     * @param userWorkExperience 用户工作经历
     * @return 结果
     */
    public int insertUserWorkExperience(UserWorkExperience userWorkExperience);

    /**
     * 修改用户工作经历
     * 
     * @param userWorkExperience 用户工作经历
     * @return 结果
     */
    public int updateUserWorkExperience(UserWorkExperience userWorkExperience);

    /**
     * 删除用户工作经历
     * 
     * @param id 用户工作经历ID
     * @return 结果
     */
    public int deleteUserWorkExperienceById(Long id);

    /**
     * 批量删除用户工作经历
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserWorkExperienceByIds(Long[] ids);
}
