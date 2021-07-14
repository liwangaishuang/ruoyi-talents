package com.ruoyi.talents.mapper;

import java.util.List;
import com.ruoyi.talents.domain.UserEducationExperience;

/**
 * 用户教育经历Mapper接口
 * 
 * @author ruoyi
 * @date 2021-06-26
 */
public interface UserEducationExperienceMapper 
{
    /**
     * 查询用户教育经历
     * 
     * @param id 用户教育经历ID
     * @return 用户教育经历
     */
    public List<UserEducationExperience> selectUserEducationExperienceById(Long id);

    /**
     * 查询用户教育经历列表
     * 
     * @param userEducationExperience 用户教育经历
     * @return 用户教育经历集合
     */
    public List<UserEducationExperience> selectUserEducationExperienceList(UserEducationExperience userEducationExperience);

    /**
     * 新增用户教育经历
     * 
     * @param userEducationExperience 用户教育经历
     * @return 结果
     */
    public int insertUserEducationExperience(UserEducationExperience userEducationExperience);

    /**
     * 修改用户教育经历
     * 
     * @param userEducationExperience 用户教育经历
     * @return 结果
     */
    public int updateUserEducationExperience(UserEducationExperience userEducationExperience);

    /**
     * 删除用户教育经历
     * 
     * @param id 用户教育经历ID
     * @return 结果
     */
    public int deleteUserEducationExperienceById(Long id);

    /**
     * 批量删除用户教育经历
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserEducationExperienceByIds(Long[] ids);

    /**
     * 批量userId删除用户教育经历
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserEducationExperienceByUserIds(Long[] ids);

    /**
     * 根据userId删除用户教育经历
     *
     * @param id 用户教育经历ID
     * @return 结果
     */
    public int deleteUserEducationExperienceByUserId(Long id);


}
