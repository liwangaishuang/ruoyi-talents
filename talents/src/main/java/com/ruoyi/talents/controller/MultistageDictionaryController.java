package com.ruoyi.talents.controller;

import java.util.List;

import com.ruoyi.talents.mapper.MultistageDictionaryMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.talents.domain.MultistageDictionary;
import com.ruoyi.talents.service.IMultistageDictionaryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 多级字典Controller
 * 
 * @author ruoyi
 * @date 2021-07-16
 */
@RestController
@RequestMapping("/dictionary")
@Api(value = "多级字典",tags = "多级字典")
public class MultistageDictionaryController extends BaseController {
    @Autowired
    private IMultistageDictionaryService multistageDictionaryService;

    /**
     * 查询多级字典列表
     */
    @PreAuthorize("@ss.hasPermi('talents:dictionary:list')")
    @GetMapping("/list")
    @ApiOperation(httpMethod = "GET",value = "查询多级字典列表")
    public MultistageDictionary list(String id){
        return multistageDictionaryService.selectMultistageDictionaryList(id);
    }


    @Autowired
    private MultistageDictionaryMapper mapper;

    @GetMapping("/test")
    @ApiOperation(httpMethod = "GET",value = "test")
    public int companyType() {
        List<MultistageDictionary> list = mapper.test();
        List<MultistageDictionary> list2 = mapper.test2();
        int i=0;
        System.out.println("==================================================");
        System.out.println(list);
        System.out.println("==================================================");
        System.out.println(list2);
        System.out.println("==================================================");
        for (MultistageDictionary m :list) {
            for (MultistageDictionary m2 :list2) {
                if (ObjectUtils.isNotEmpty(m.getDictValue()) && ObjectUtils.isNotEmpty(m2.getParentId())){
                    if (m.getDictValue().equals(m2.getParentId())){
                        m2.setParentId(m.getId()+"");
                        mapper.update(m2);
                    }
                }

            }
        }
        return i;
    }

}
