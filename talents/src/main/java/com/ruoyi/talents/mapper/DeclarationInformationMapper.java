package com.ruoyi.talents.mapper;

import java.util.List;
import com.ruoyi.talents.domain.DeclarationInformation;

/**
 * 申报信息Mapper接口
 * 
 * @author ruoyi
 * @date 2021-07-19
 */
public interface DeclarationInformationMapper 
{
    /**
     * 查询申报信息
     * 
     * @param id 申报信息ID
     * @return 申报信息
     */
    public DeclarationInformation selectDeclarationInformationById(Long id);

    /**
     * 查询申报信息列表
     * 
     * @param declarationInformation 申报信息
     * @return 申报信息集合
     */
    public List<DeclarationInformation> selectDeclarationInformationList(DeclarationInformation declarationInformation);

    /**
     * 新增申报信息
     * 
     * @param declarationInformation 申报信息
     * @return 结果
     */
    public int insertDeclarationInformation(DeclarationInformation declarationInformation);

    /**
     * 修改申报信息
     * 
     * @param declarationInformation 申报信息
     * @return 结果
     */
    public int updateDeclarationInformation(DeclarationInformation declarationInformation);

    /**
     * 删除申报信息
     * 
     * @param id 申报信息ID
     * @return 结果
     */
    public int deleteDeclarationInformationById(Long id);

    /**
     * 批量删除申报信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDeclarationInformationByIds(Long[] ids);
}
