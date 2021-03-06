package com.ruoyi.talents.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.talents.domain.User;
import com.ruoyi.talents.domain.dto.UserDto;
import com.ruoyi.talents.domain.vo.DistributionVo;
import com.ruoyi.talents.domain.vo.ExportUserVo;
import com.ruoyi.talents.domain.vo.NewestUserVo;

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
     * 获取当前用户详细信息(跳转查看专家申报信息)
     * */
    public User getUserNowInfo();

    public NewestUserVo getNewestInfo();

    /**
     * 查询用户列表
     *
     * @param user 用户
     * @return 用户集合
     */
    public List<User> selectUserList(User user);

    /**导出人才管理用户*/
    public List<ExportUserVo> selectUserList2(User user);

    /**导出人才移除用户*/
    public List<ExportUserVo> selectUserList3(User user);

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

    /**审批*/
    public int examineUser(Map map);

    /**移除专家库*/
    public int removeUser(Map map);

    /**移回专家库*/
    public int retractUserById(Long[] ids);

    /**修改用户密码*/
    public int editPassword(SysUser sysUser);

    /**
     * 批量删除用户
     *
     * @param ids 需要删除的用户ID
     * @return 结果
     */
    public int deleteUserByIds(Long[] ids);

    /**
     * 删除用户信息
     *
     * @param id 用户ID
     * @return 结果
     */
    public int deleteUserById(Long id);

    /**申报数据统计*/
    public Map statisticsList();

    /**人才/企业区域分布*/
    public List<DistributionVo> distributionList();

    /**年龄与性别分布*/
    public Map ageAndSexList();

    /**学历分布和专业类别*/
    public Map specialityAndEducationMap();

    /**申报趋势*/
    public List trendList(int isMonth);

    /**
     单位类别
     */
    public List companyType(String type);

    /**
     人才专家行业领域分布
     * */
    public List companyRegion(String type);













}
