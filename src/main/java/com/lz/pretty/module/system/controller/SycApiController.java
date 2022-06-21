package com.lz.pretty.module.system.controller;

import com.lz.pretty.common.domain.AjaxResponse;
import com.lz.pretty.module.system.model.SysApi;
import com.lz.pretty.module.system.model.dto.RoleCheckedIdsDTO;
import com.lz.pretty.module.system.service.SysApiService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;

/**
 * 类描述:Api管理
 *
 * @author Lz on 2022-06-21
 */
@RestController
@RequestMapping("/sysapi")
public class SycApiController {

    @Resource
    private SysApiService sysapiService;

    @PostMapping(value = "/tree")
    public AjaxResponse tree(@RequestParam("apiNameLike") String apiNameLike,
                             @RequestParam("apiStatus") Boolean apiStatus) {

        return AjaxResponse.success(sysapiService.getApiTreeById(apiNameLike, apiStatus));
    }

    @PostMapping(value = "/update")
    public AjaxResponse update(@RequestBody SysApi sysApi) {
        sysapiService.updateApi(sysApi);
        return AjaxResponse.success("更新接口配置成功！");
    }

    @PostMapping(value = "/add")
    public AjaxResponse add(@RequestBody SysApi sysApi) {
        sysapiService.addApi(sysApi);
        return AjaxResponse.success("新增接口配置成功！");
    }


    @PostMapping(value = "/delete")
    public AjaxResponse delete(@RequestBody SysApi sysApi) {
        sysapiService.deleteApi(sysApi);
        return AjaxResponse.success("删除接口配置成功!");
    }

    /**
     * 查询 API 树形结构：全部、已选、展开
     *
     * @return
     */
    @PostMapping(value = "/checkedtree")
    public AjaxResponse checkedtree(@RequestParam Integer roleId) {
        HashMap<String, Object> apiMaps = new HashMap<>();
        apiMaps.put("tree", sysapiService.getApiTreeById("", null));
        apiMaps.put("expendedKeys", sysapiService.getExpandedKeys());
        apiMaps.put("checkedKeys", sysapiService.getCheckedKeys(roleId));
        return AjaxResponse.success(apiMaps);
    }

    /**
     * 保存角色 API 权限
     *
     * @param roleCheckedIds
     * @return
     */
    @PostMapping(value = "/saveKeys")
    public AjaxResponse saveKeys(@RequestBody @Valid RoleCheckedIdsDTO roleCheckedIds) {
        sysapiService.saveCheckedKeys(
                roleCheckedIds.getRoleId(),
                roleCheckedIds.getCheckedIds()
        );
        return AjaxResponse.success("保存接口权限成功！");
    }


}
