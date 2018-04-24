package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Product;
import com.mmall.vo.ProductDetailVo;

/**
 * Created by songy on 2017/12/18.
 */
public interface IProductService {

    //增加或新增产品
    ServerResponse saveOrUpdateProduct(Product product);

    //修改产品销售状态
    ServerResponse<String> setSaleStatus(Integer productId, Integer status);

    //获取后台产品详情
    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);

    //后台商品列表分页
    ServerResponse<PageInfo> getProductList(int pageNum, int pageSize);

    //后台商品搜索
    ServerResponse<PageInfo> searchProduct(String productName, Integer productId, int pageNum, int pageSize);

    //前台商品详情
    ServerResponse<ProductDetailVo> getProductDetail(Integer productId);

    //前台关键字搜索
    ServerResponse<PageInfo> getProductByKeywordCategory(String keyword, Integer categoryId, int pageNum, int pageSize, String orderBy);

}
