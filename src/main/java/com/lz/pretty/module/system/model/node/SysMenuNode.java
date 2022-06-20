package com.lz.pretty.module.system.model.node;

import com.lz.pretty.common.utils.tree.DataTree;
import com.lz.pretty.module.system.model.SysMenu;

import java.util.List;

/**
 * 类描述: 菜单树对象
 *
 * @author Lz on 2022-06-20
 */
public class SysMenuNode extends SysMenu implements DataTree<SysMenuNode, Long> {

    private List<SysMenuNode> children;

    @Override
    public Long getParentId() {
        return super.getId();
    }

    @Override
    public void setChildren(List<SysMenuNode> children) {
        this.children = children;
    }

    @Override
    public List<SysMenuNode> getChildren() {
        return this.children;
    }
}
