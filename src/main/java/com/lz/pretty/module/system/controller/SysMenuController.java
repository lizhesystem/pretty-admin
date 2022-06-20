package com.lz.pretty.module.system.controller;

import com.lz.pretty.module.system.model.node.SysMenuNode;
import com.lz.pretty.module.system.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 类描述: 菜单管理
 *
 * @author Lz on 2022-06-20
 */
@RestController
@RequestMapping("/menu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    public List<SysMenuNode> tree(@RequestParam("menuNameLike") String menuNameLike,
                                  @RequestParam("menuStatus") Boolean menuStatus) {

        return sysMenuService.getMenuTree(menuNameLike,menuStatus);
    }


}
