package com.ruoyi.talents.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.talents.mapper.DeclarationInformationMapper;
import com.ruoyi.talents.domain.DeclarationInformation;
import com.ruoyi.talents.service.IDeclarationInformationService;

/**
 * 申报信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-07-19
 */
@Service
public class DeclarationInformationServiceImpl implements IDeclarationInformationService 
{
    @Autowired
    private DeclarationInformationMapper declarationInformationMapper;

    /**
     * 查询申报信息
     * 
     * @param id 申报信息ID
     * @return 申报信息
     */
    @Override
    public DeclarationInformation selectDeclarationInformationById(Long id)
    {
        return declarationInformationMapper.selectDeclarationInformationById(id);
    }

    /**
     * 根据userId查询申报信息
     * */
    @Override
    public DeclarationInformation selectDeclarationInformationByUserId(String userId) {
        return declarationInformationMapper.selectDeclarationInformationByUserId(userId);
    }

    /**
     * 查询申报信息列表
     * 
     * @param declarationInformation 申报信息
     * @return 申报信息
     */
    @Override
    public List<DeclarationInformation> selectDeclarationInformationList(DeclarationInformation declarationInformation)
    {
        return declarationInformationMapper.selectDeclarationInformationList(declarationInformation);
    }

    /**
     * 新增申报信息
     * 
     * @param declarationInformation 申报信息
     * @return 结果
     */
    @Override
    public int insertDeclarationInformation(DeclarationInformation declarationInformation)
    {
        declarationInformation.setCreateTime(DateUtils.getNowDate());
        return declarationInformationMapper.insertDeclarationInformation(declarationInformation);
    }

    /**
     * 修改申报信息
     * 
     * @param declarationInformation 申报信息
     * @return 结果
     */
    @Override
    public int updateDeclarationInformation(DeclarationInformation declarationInformation)
    {
        return declarationInformationMapper.updateDeclarationInformation(declarationInformation);
    }

    /**
     * 批量删除申报信息
     * 
     * @param ids 需要删除的申报信息ID
     * @return 结果
     */
    @Override
    public int deleteDeclarationInformationByIds(Long[] ids)
    {
        return declarationInformationMapper.deleteDeclarationInformationByIds(ids);
    }

    /**
     * 删除申报信息信息
     * 
     * @param id 申报信息ID
     * @return 结果
     */
    @Override
    public int deleteDeclarationInformationById(Long id)
    {
        return declarationInformationMapper.deleteDeclarationInformationById(id);
    }
}
