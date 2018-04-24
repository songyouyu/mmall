package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.vo.CartVo;

/**
 * Created by songy on 2018/1/3.
 */
public interface ICartService {

    //加入购物车
    ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count);

    //更新购物车
    ServerResponse<CartVo> update(Integer userId, Integer productId, Integer count);

    //删除购物车
    ServerResponse<CartVo> deleteProduct(Integer userId, String productIds);

    //查询购物车
    ServerResponse<CartVo> list(Integer userId);

    //全选、全反选
    ServerResponse<CartVo> selectOrUnSelect(Integer userId, Integer checked, Integer productId);

    //查询当前用户的购物车里面的产品数量
    ServerResponse<Integer> getCartProductCount(Integer userId);

}
