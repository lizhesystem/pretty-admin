package com.lz.pretty.module.system.controller;

import com.lz.pretty.common.controller.BaseController;
import com.lz.pretty.common.domain.AjaxResponse;
import com.lz.pretty.common.page.TableDataInfo;
import com.lz.pretty.module.system.model.SysDict;
import com.lz.pretty.module.system.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 类描述:数据字典
 *
 * @author Lz on 2022-06-22
 */
@RestController
@RequestMapping("/sysdict")
public class SysDictController extends BaseController {

    @Autowired
    private SysDictService sysDictService;

    /**
     * 查询所有字段数据(不分页)
     *
     * @return
     */
    @PostMapping("/all")
    public AjaxResponse all() {
        return AjaxResponse.success(sysDictService.all());
    }

    /**
     * 根据名称或者编码模糊查找
     *
     * @param groupName 分组名称
     * @param groupCode 分组编码
     * @return 数据字典列表
     */
    @PostMapping("/query")
    public AjaxResponse queryList(@RequestParam String groupName,
                                  @RequestParam String groupCode) {
        return AjaxResponse.success(sysDictService.query(groupName, groupCode));
    }

    /**
     * 根据名称或者编码模糊查找（分页）
     *
     * @param groupName 分组名称
     * @param groupCode 分组编码
     * @param itemDesc  字典描述
     * @return 数据字典列表
     */
    @PostMapping("/query/page")
    public TableDataInfo queryListPage(@RequestParam String groupName,
                                       @RequestParam String groupCode,
                                       @RequestParam String itemDesc) {
        startPage();
        List<SysDict> sysDictList = sysDictService.queryPage(groupName, groupCode, itemDesc);
        return getDataTable(sysDictList);
    }

    @PostMapping("/add")
    public AjaxResponse add(@RequestBody SysDict sysDict) {
        sysDictService.addDict(sysDict);
        return AjaxResponse.success("新增数据字典成功");
    }

    /**
     * 根据id更新数据数据字典项目
     *
     * @param sysDict 更新实体（必须包含id）
     * @return 更新成功结果
     */
    @PostMapping(value = "/update")
    public AjaxResponse update(@RequestBody SysDict sysDict) {
        sysDictService.update(sysDict);
        return AjaxResponse.success("更新数据字典项成功！");
    }

    /**
     * 根据id删除数据字典项
     *
     * @param id 删除项id
     * @return 删除成功结果
     */
    @PostMapping(value = "/delete")
    public AjaxResponse delete(@RequestParam Long id) {
        sysDictService.delete(id);
        return AjaxResponse.success("删除数据字典项成功!");
    }
}
