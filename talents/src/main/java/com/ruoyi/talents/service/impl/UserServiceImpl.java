package com.ruoyi.talents.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.talents.domain.UserEducationExperience;
import com.ruoyi.talents.domain.UserOccupational;
import com.ruoyi.talents.domain.UserWorkExperience;
import com.ruoyi.talents.domain.dto.UserDto;
import com.ruoyi.talents.mapper.UserEducationExperienceMapper;
import com.ruoyi.talents.mapper.UserOccupationalMapper;
import com.ruoyi.talents.mapper.UserWorkExperienceMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.talents.mapper.UserMapper;
import com.ruoyi.talents.domain.User;
import com.ruoyi.talents.service.IUserService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户Service业务层处理
 *
 * @author ruoyi
 * @date 2021-06-11
 */
@Service
public class UserServiceImpl implements IUserService
{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserEducationExperienceMapper educationExperienceMapper;
    @Autowired
    private UserOccupationalMapper occupationalMapper;
    @Autowired
    private UserWorkExperienceMapper workExperienceMapper;


    /**
     * 查询用户
     *
     * @param id 用户ID
     * @return 用户
     */
    @Override
    public User selectUserById(String id)
    {
        User user = setUser(userMapper.selectUserById(id));
        return user;
    }

    /**
     * 查询用户列表
     *
     * @param user 用户
     * @return 用户
     */
    @Override
    @Transactional
    public List<User> selectUserList(User user)
    {
        List<User> users = userMapper.selectUserList(user);
        if (ObjectUtils.isEmpty(users)){
            return null;
        }
        for (User user2:users) {
            setUser(user2);
        }
        return users;
    }

    /**查询人才专家库列表*/
    @Override
    @Transactional
    public List<User> selectSpecialistList(User user)
    {
        List<User> users = userMapper.selectSpecialistList(user);
        if (!ObjectUtils.isEmpty(users)){
            for (User user2:users) {
                setUser(user2);
            }
        }

        return users;
    }

    /**查询人才移除管理列表*/
    @Override
    @Transactional
    public List<User> selectRemoveList(User user)
    {
        List<User> users = userMapper.selectRemoveList(user);
        if (!ObjectUtils.isEmpty(users)){
            for (User user2:users) {
                setUser(user2);
            }
        }
        return users;
    }

    /**查询人才申报审批列表*/
    @Override
    @Transactional
    public List<User> selectExamineList(User user)
    {
        List<User> users = userMapper.selectExamineList(user);
        if (!ObjectUtils.isEmpty(users)){
            for (User user2:users) {
                setUser(user2);
            }
        }
        return users;
    }

    /**注册用户*/
    @Override
    @Transactional
    public List<UserDto> selectRegisteredList(UserDto userDto)
    {
        List<UserDto> users = userMapper.selectRegisteredList(userDto);
        return users;
    }

    /**
     * 新增用户
     *
     * @param user 用户
     * @return 结果
     */
    @Override
    @Transactional
    public int insertUser(User user)
    {
        /**先插入user相关表*/
        if (ObjectUtils.isNotEmpty(user.getExperience())){
            educationExperienceMapper.insertUserEducationExperience(user.getExperience());
        }
        if (ObjectUtils.isNotEmpty(user.getWorkExperience())){
            workExperienceMapper.insertUserWorkExperience(user.getWorkExperience());
        }
        if(ObjectUtils.isNotEmpty(user.getOccupational())){
            occupationalMapper.insertUserOccupational(user.getOccupational());
        }
        user.setCreateTime(DateUtils.getNowDate());
        return userMapper.insertUser(user);
    }

    /**
     * 修改用户
     *
     * @param user 用户
     * @return 结果
     */
    @Override
    @Transactional
    public int updateUser(User user)
    {
        /**先修改user相关表*/
        educationExperienceMapper.updateUserEducationExperience(user.getExperience());
        workExperienceMapper.updateUserWorkExperience(user.getWorkExperience());
        occupationalMapper.updateUserOccupational(user.getOccupational());

        user.setUpdateTime(DateUtils.getNowDate());
        return userMapper.updateUser(user);
    }

    /**审批*/
    @Override
    @Transactional
    public int examineUser(Map map)
    {   map.put("updateTime",DateUtils.getNowDate());
        map.put("auditTime",DateUtils.getNowDate());
        map.put("status","2");
        map.put("isRemove","0");
        if (ObjectUtils.isEmpty(map.get("id"))){
            return 0;
        }
        return userMapper.examineUser(map);
    }

    /**移除专家库*/
    @Override
    @Transactional
    public int removeUser(Map map)
    {
        if("0".equals(map.get("removeType"))){
            map.put("removeOverTime","永久移除");
        }else {
            String removeOverTime = ((String) map.get("removeOverTime")).substring(0, 10);
            map.put("removeOverTime",removeOverTime);
        }
        map.put("isRemove","1");
        map.put("removeTime",new Date());
        return userMapper.removeUser(map);
    }

    /**移回专家库*/
    @Override
    @Transactional
    public int retractUserById(Long[] ids)
    {
        return userMapper.retractUserById(ids,new Date());
    }

    /**修改用户密码*/
    @Override
    public int editPassword(SysUser sysUser)
    {   String userId=sysUser.getUserId()+"";
        Date updateTime = DateUtils.getNowDate();
        String password=SecurityUtils.encryptPassword(sysUser.getPassword());
        return userMapper.editPassword(userId,password,updateTime);
    }


    /**
     * 批量删除用户
     *
     * @param ids 需要删除的用户ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteUserByIds(Long[] ids)
    {
        /**先删除user相关表*/
        if (ObjectUtils.isNotEmpty(ids)){
            educationExperienceMapper.deleteUserEducationExperienceByUserIds(ids);
            workExperienceMapper.deleteUserWorkExperienceByUserIds(ids);
            occupationalMapper.deleteUserOccupationalByUserIds(ids);
        }

        return userMapper.deleteUserByIds(ids);
    }

    /**
     * 删除用户信息
     *
     * @param id 用户ID
     * @return 结果
     */
    @Override
    public int deleteUserById(Long id)
    {
        /**先删除user相关表*/
        if (ObjectUtils.isNotEmpty(id)){
            educationExperienceMapper.deleteUserEducationExperienceByUserId(id);
            workExperienceMapper.deleteUserWorkExperienceByUserId(id);
            occupationalMapper.deleteUserOccupationalByUserId(id);
        }

        return userMapper.deleteUserById(id);
    }

    public User setUser(User user){
        /**先查询user相关表*/
        if (ObjectUtils.isNotEmpty(user)){
            user.setExperience(educationExperienceMapper.selectUserEducationExperienceById(user.getId()));
            user.setWorkExperience(workExperienceMapper.selectUserWorkExperienceById(user.getId()));
            user.setOccupational(occupationalMapper.selectUserOccupationalById(user.getId()));
        }
        return user;
    }
}
