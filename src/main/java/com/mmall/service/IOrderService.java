package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.vo.OrderProductVo;
import com.mmall.vo.OrderVo;

import java.util.Map;

/**
 * Created by song on 2018/1/10
 */
public interface IOrderService {

    //支付
    ServerResponse pay(Long orderNo, Integer userId, String path);

    //支付宝回调
    ServerResponse aliCallback(Map<String, String> params);

    //查询订单支付状态
    ServerResponse queryOrderPayStatus(Integer userId, Long orderNo);

    //创建订单
    ServerResponse createOrder(Integer userId, Integer shippingId);

    //取消订单
    ServerResponse<String> cancelOrder(Integer userId, Long orderNo);

    //取购物车商品信息
    ServerResponse<OrderProductVo> getOrderCartProduct(Integer userId);

    //前台订单详情
    ServerResponse<OrderVo> getOrderDetail(Integer userId, Long orderNo);

    //前台订单列表
    ServerResponse<PageInfo> getOrderList(Integer userId, int pageNum, int pageSize);

    //后台订单详情
    ServerResponse<OrderVo> manageDetail(Long orderNo);

    //后台订单列表
    ServerResponse<PageInfo> manageList(int pageNum, int pageSize);

    //按订单号搜索
    ServerResponse<PageInfo> manageSearch(Long orderNo, int pageNum, int pageSize);

    //订单发货
    ServerResponse<String> manageSendGoods(Long orderNo);

    //hour个小时内未付款的订单，进行关闭
    void closeOrder(int hour);
}
