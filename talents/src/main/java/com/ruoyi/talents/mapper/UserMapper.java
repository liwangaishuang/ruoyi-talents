package com.ruoyi.talents.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ruoyi.talents.domain.User;
import com.ruoyi.talents.domain.dto.UserDto;
import com.ruoyi.talents.domain.vo.DistributionVo;
import com.ruoyi.talents.domain.vo.NewestUserVo;
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

    public NewestUserVo getNewestInfo(String id);

    /**该用户更早的填报数据*/
    public Long getEarlierUser(String id);

    /**查询有几条相同userId的数据*/
    public Long getUserNumber(String id);

    /**
     * 查询用户列表
     *
     * @param user 用户
     * @return 用户集合
     */
    public List<User> selectUserList(User user);

    /**查询人才专家库列表*/
    public List<User> selectSpecialistList(User user);

    /**查询人才移除管理列表*/
    public List<User> selectRemoveList(User user);

    /**查询人才申报审批列表*/
    public List<User> selectExamineList(User user);

    /**注册用户*/
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

    /**修改用户id*/
    public int updateUserById(@Param(value = "formerId")Long formerId,@Param(value = "newId")Long newId);

    /**审批*/
    public int examineUser(Map map);

    /**单个审批*/
    public int examineOneUser(Map map);

    /**移除专家库*/
    public int removeUser(Map map);

    /**移回专家库*/
    public int retractUserById(@Param(value = "ids") Long[] ids,@Param(value = "updateTime") Date updateTime);

    /**修改用户密码*/
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

    /**申报数据统计*/
    public Map statisticsList();

    /**人才/企业区域分布*/
    public List<DistributionVo> distributionList();

    /**性别分布*/
    public Map sexMap();

    /**年龄分布*/
    public Map ageMap();

    /**专业类别*/
    public Map specialityMap();

    /**学历分布*/
    public Map educationMap();

    /**申报趋势*/
    public List trendMonth();
    public List trendYear();

    /**单位类别*/
    public List companyType(String type);


}
