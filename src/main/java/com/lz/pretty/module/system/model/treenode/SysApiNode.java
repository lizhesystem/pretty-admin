package com.lz.pretty.module.system.model.treenode;

import com.lz.pretty.common.utils.tree.DataTree;
import com.lz.pretty.module.system.model.SysApi;

import java.util.List;

/**
 * 类描述:
 *
 * @author Lz on 2022-06-21
 */
public class SysApiNode extends SysApi implements DataTree<SysApiNode, Long> {

    private List<SysApiNode> children;

    @Override
    public Long getParentId() {
        return super.getId();
    }

    @Override
    public void setChildren(List<SysApiNode> children) {
        this.children = children;
    }

    @Override
    public List<SysApiNode> getChildren() {
        return this.children;
    }
}
