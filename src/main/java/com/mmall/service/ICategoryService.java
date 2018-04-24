package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Category;

import java.util.List;

/**
 * Created by songy on 2017/12/18.
 */
public interface ICategoryService {

    //增加分类
    ServerResponse addCategory(String categoryName, Integer parentId);

    //修改分类名称
    ServerResponse updateCategoryName(Integer categoryId, String categoryName);

    //查询子节点(平级)分类名称
    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);

    //递归查询本节点id和孩子节点id
    ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);
}
