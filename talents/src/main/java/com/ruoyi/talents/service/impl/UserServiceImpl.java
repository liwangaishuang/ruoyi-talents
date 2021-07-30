package com.ruoyi.talents.service.impl;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.talents.domain.*;
import com.ruoyi.talents.domain.dto.UserDto;
import com.ruoyi.talents.domain.vo.DistributionVo;
import com.ruoyi.talents.domain.vo.ExportUserVo;
import com.ruoyi.talents.domain.vo.NewestUserVo;
import com.ruoyi.talents.mapper.UserEducationExperienceMapper;
import com.ruoyi.talents.mapper.UserMapper;
import com.ruoyi.talents.mapper.UserOccupationalMapper;
import com.ruoyi.talents.mapper.UserWorkExperienceMapper;
import com.ruoyi.talents.service.IDeclarationInformationService;
import com.ruoyi.talents.service.IUserService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private IDeclarationInformationService informationService;
    @Autowired
    private TokenService tokenService;

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
     * 获取当前用户详细信息(跳转查看专家申报信息)
     * */
    @Override
    public User getUserNowInfo() {
        String id = SecurityUtils.getLoginUser().getUser().getUserId()+"";
        User user = setUser(userMapper.getUserNowInfo(id));
        return user;
    }

    @Override
    public NewestUserVo getNewestInfo() {
        String id = SecurityUtils.getLoginUser().getUser().getUserId()+"";
        NewestUserVo info = userMapper.getNewestInfo(id);
        /**判断该用户处于什么状态*/
        /*if (){

        }*/
        return info;
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

    @Override
    @Transactional
    public List<ExportUserVo> selectUserList2(User user) {
        List<ExportUserVo> users=null;
        if (ObjectUtils.isNotEmpty(user.getIds())){
            users= userMapper.selectListByIds(user.getIds());
        }else {
            users= userMapper.selectSpecialistList2(user);
        }
        if (ObjectUtils.isEmpty(users)){
            return null;
        }
        for (ExportUserVo user2:users) {
            setUser2(user2);
        }
        return users;
    }

    @Override
    @Transactional
    public List<ExportUserVo> selectUserList3(User user) {
        List<ExportUserVo> users=null;
        if (ObjectUtils.isNotEmpty(user.getIds())){
            users= userMapper.selectListByIds(user.getIds());
        }else {
            users= userMapper.selectSpecialistList3(user);
        }
        if (ObjectUtils.isEmpty(users)){
            return null;
        }
        for (ExportUserVo user2:users) {
            setUser2(user2);
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
            for (UserEducationExperience experience : user.getExperience()) {
                educationExperienceMapper.insertUserEducationExperience(experience);
            }
        }
        if (ObjectUtils.isNotEmpty(user.getWorkExperience())){
            for (UserWorkExperience workExperience : user.getWorkExperience()) {
                workExperienceMapper.insertUserWorkExperience(workExperience);
            }
        }
        if(ObjectUtils.isNotEmpty(user.getOccupational())){
            for (UserOccupational occupational : user.getOccupational()) {
                occupationalMapper.insertUserOccupational(occupational);
            }
        }
        user.setCreateTime(DateUtils.getNowDate());

        int i = userMapper.insertUser(user);
        /**新增完插入数据到进度表*/
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        DeclarationInformation information = new DeclarationInformation();
        information.setUserId(user.getUserId());
        information.setDeclarationId(user.getId()+"");
        information.setOperator(loginUser.getUser().getUserName());
        information.setOperationalContext("提交申报");
        information.setApplicationStatus("0");
        informationService.insertDeclarationInformation(information);
        return i;
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
        for (UserEducationExperience experience : user.getExperience()) {
            educationExperienceMapper.updateUserEducationExperience(experience);
        }
        for (UserWorkExperience workExperience : user.getWorkExperience()) {
            workExperienceMapper.updateUserWorkExperience(workExperience);
        }
        for (UserOccupational occupational : user.getOccupational()) {
            occupationalMapper.updateUserOccupational(occupational);
        }

        user.setUpdateTime(DateUtils.getNowDate());
        return userMapper.updateUser(user);
    }

    /**审批*/
    @Override
    @Transactional
    public int examineUser(Map map) {
        map.put("updateTime",DateUtils.getNowDate());
        map.put("auditTime",DateUtils.getNowDate());
        map.put("status","2");
        map.put("isRemove","0");
        if (ObjectUtils.isEmpty(map.get("id"))){
            return 0;
        }
        List<Integer> ids = (List)map.get("id");
        /**当该用户审批通过时，则判断该用户是否已在人才专家库，如果在则更新该用户的数据*/
        /**如果审批通过*/
        if ("0".equals(map.get("examineStatus"))){
            /**因可能有多个用户同时通过，所以需要循环*/
            for (Integer id: ids) {
                User user = userMapper.selectUserById(id+"");
                String userId = user.getUserId();
                /**查询相同userId的数据共有几条*/
                Long number = userMapper.getUserNumber(userId);
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("id",id);
                if (number>1){
                    /**删除旧数据*/
                    //userMapper.deleteEarlierUser(userId);
                }
                hashMap.put("updateTime",DateUtils.getNowDate());
                hashMap.put("auditTime",DateUtils.getNowDate());
                hashMap.put("status","2");
                hashMap.put("isRemove","0");
                hashMap.put("examineStatus",map.get("examineStatus"));
                hashMap.put("auditExplain",map.get("auditExplain"));
                userMapper.examineOneUser(hashMap);

                /**把审核通过的操作存入操作表*/
                //得到当前用户的用户名
                LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
                DeclarationInformation information = new DeclarationInformation();
                information.setUserId(userId);
                information.setDeclarationId(hashMap.get("id")+"");
                information.setOperator(loginUser.getUser().getUserName());
                information.setOperationalContext("审核申报");
                information.setApplicationStatus("1");
                information.setIsPass("0");
                information.setRemark(map.get("auditExplain")+"");
                informationService.insertDeclarationInformation(information);
                /**修改最初申报的申报id*/
                /*DeclarationInformation information1 = informationService.selectDeclarationInformationByUserId(userId);
                information1.setDeclarationId(hashMap.get("id")+"");
                informationService.updateDeclarationInformation(information1);*/
            }
            return ids.size();
        }
        for (Integer id:ids) {
            User user = userMapper.selectUserById(id+"");
            String userId = user.getUserId();
            //得到当前用户的用户名
            LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
            DeclarationInformation information = new DeclarationInformation();
            information.setUserId(userId);
            information.setDeclarationId(user.getId()+"");
            information.setOperator(loginUser.getUser().getUserName());
            information.setOperationalContext("审核申报");
            information.setApplicationStatus("1");
            information.setIsPass("1");
            information.setRemark(map.get("auditExplain")+"");
            informationService.insertDeclarationInformation(information);
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

    /**申报数据统计*/
    @Override
    public Map statisticsList() {
        Map map = userMapper.statisticsList();
        return map;
    }

    /**人才/企业区域分布*/
    @Override
    public List<DistributionVo> distributionList() {
        return userMapper.distributionList();
    }

    /**年龄与性别分布*/
    @Override
    public Map ageAndSexList() {
        HashMap<String, Map> map = new HashMap<>();
        map.put("sex",userMapper.sexMap());
        map.put("age",userMapper.ageMap());
        return map;
    }

    /**学历分布和专业类别*/
    @Override
    public Map specialityAndEducationMap() {
        HashMap<String, Map> map = new HashMap<>();
        map.put("speciality",userMapper.specialityMap());
        map.put("education",userMapper.educationMap());
        return map;
    }

    /**申报趋势*/
    @Override
    public List trendList(int isMonth) {
        /**0:月度 1:年度*/
        if (isMonth==0){
            return userMapper.trendMonth();
        }else if(isMonth==1){
            return userMapper.trendYear();
        }
        return null;
    }

    /**单位类别*/
    @Override
    public List companyType(String type) {
        return userMapper.companyType(type);
    }

    /**人才专家行业领域分布*/
    @Override
    public List companyRegion(String type) {
        return userMapper.companyRegion(type);
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

    public ExportUserVo setUser2(ExportUserVo user){
        /**先查询user相关表*/
        if (ObjectUtils.isNotEmpty(user)){
            user.setExperience(educationExperienceMapper.selectUserEducationExperienceById(user.getId()));
            user.setWorkExperience(workExperienceMapper.selectUserWorkExperienceById(user.getId()));
            user.setOccupational(occupationalMapper.selectUserOccupationalById(user.getId()));
        }
        return user;
    }
}
