package com.lz.pretty.common.utils.tree;

import java.util.List;

/**
 * 接口描述: tree关系工具接口
 *
 * @author Lz on 2022-06-17
 */
public interface DataTree<T, ID> {

    public ID getId();

    public ID getParentId();

    public void setChildren(List<T> children);

    public List<T> getChildren();
}
