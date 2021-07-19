package com.ruoyi.talents.controller;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.talents.mapper.MultistageDictionaryMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
    @ApiImplicitParam(name = "id",value = "(1:专业 2:行业领域 3:基金学科 4:国标学科 5:教育学科 6:工业行业)",dataType = "String")
    public MultistageDictionary list(String id){
        return multistageDictionaryService.selectMultistageDictionaryList(id);
    }

    /*@Transactional
    @GetMapping("/test2")
    @ApiOperation(httpMethod = "GET",value = "导入数据")
    public MultistageDictionary test(){
        String jsonData="";

        JSONObject jsonObject = JSONArray.parseObject(jsonData);
        List<JSONObject> list =(List)jsonObject.get("result");
        for (JSONObject o1:list) {
            recursion(o1,"6");
        }
        return null;
    }*/

    public JSONObject recursion(JSONObject jsonObject,String i){
        MultistageDictionary dictionary2 = new MultistageDictionary();
        dictionary2.setDictValue(jsonObject.get("label") + "");
        dictionary2.setParentId(i + "");
        multistageDictionaryService.insertMultistageDictionary(dictionary2);
        String s=dictionary2.getId()+"";
        if (ObjectUtils.isNotEmpty(jsonObject.get("children"))) {
            List<JSONObject> list2 = (List) jsonObject.get("children");
            for (JSONObject o2 : list2) {
                recursion(o2,s);
            }
        }
        return jsonObject;
    }



    /*@Autowired
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
    }*/

}
