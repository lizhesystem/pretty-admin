package com.lz.pretty.module.system.controller;

import com.lz.pretty.common.controller.BaseController;
import com.lz.pretty.common.domain.AjaxResponse;
import com.lz.pretty.common.page.TableDataInfo;
import com.lz.pretty.config.DbLoadSysConfig;
import com.lz.pretty.module.system.model.SysConfig;
import com.lz.pretty.module.system.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 类描述:
 *
 * @author Lz on 2022-06-22
 */
@RestController
@RequestMapping("/sysconfig")
public class SysConfigController extends BaseController {

    @Autowired
    SysConfigService sysConfigService;

    @Autowired
    DbLoadSysConfig dbLoadSysConfig;

    // 获取所有不带分页
    @PostMapping("/all")
    public AjaxResponse all() {
        return AjaxResponse.success(dbLoadSysConfig.getSysConfigList());
    }

    // 刷新缓存
    @PostMapping("/refresh")
    public AjaxResponse refresh() {
        dbLoadSysConfig.getSysConfigList();
        return AjaxResponse.success("刷新参数成功");
    }

    // 分页查询
    @PostMapping("/query")
    public TableDataInfo all(@RequestParam String paramName, @RequestParam String paramDesc) {
        startPage();
        List<SysConfig> sysConfigList = sysConfigService.getAll(paramName, paramDesc);
        return getDataTable(sysConfigList);
    }

    @PostMapping(value = "/update")
    public AjaxResponse update(@RequestBody SysConfig sysConfig) {
        sysConfigService.updateConfig(sysConfig);
        return AjaxResponse.success("更新配置成功！");
    }


    @PostMapping(value = "/add")
    public AjaxResponse add(@RequestBody SysConfig sysConfig) {
        sysConfigService.addConfig(sysConfig);
        return AjaxResponse.success("新增配置成功！");
    }

    @PostMapping(value = "/delete")
    public AjaxResponse delete(@RequestParam Long configId) {
        sysConfigService.deleteConfig(configId);
        return AjaxResponse.success("删除配置成功!");
    }

}
