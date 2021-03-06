package com.mmall.controller.backend;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ResponseCode;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.IOrderService;
import com.mmall.service.IUserService;
import com.mmall.util.CookieUtil;
import com.mmall.util.JsonUtil;
import com.mmall.util.RedisShardedPoolUtil;
import com.mmall.vo.OrderVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by song on 2018/1/14
 */
@Controller
@RequestMapping("/manage/order")
public class OrderManageController {

    @Autowired
    private IUserService iUserService;
    @Autowired
    private IOrderService iOrderService;

    /**
     * 后台订单列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse<PageInfo> orderList(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                              @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
//        String loginToken = CookieUtil.readLoginToken(request);
//        if (StringUtils.isEmpty(loginToken)) {
//            return ServerResponse.createByErrorMessage("该用户未登录，无法获取当前用户的信息");
//        }
//        String userJsonStr = RedisShardedPoolUtil.get(loginToken);
//        User user = JsonUtil.string2Obj(userJsonStr, User.class);
//        if (user == null) {
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请登录");
//        }
//        if (iUserService.checkAdminRole(user).isSuccess()) {
//            //增加产品的业务逻辑
//            return iOrderService.manageList(pageNum, pageSize);
//        } else {
//            return ServerResponse.createByErrorMessage("该用户没有权限");
//        }
        //全部通过拦截器验证是否登录以及是否是管理员
        return iOrderService.manageList(pageNum, pageSize);
    }

    /**
     * 后台订单详情
     * @param orderNo
     * @return
     */
    @RequestMapping("detail.do")
    @ResponseBody
    public ServerResponse<OrderVo> orderDetail(HttpServletRequest request, Long orderNo) {
//        String loginToken = CookieUtil.readLoginToken(request);
//        if (StringUtils.isEmpty(loginToken)) {
//            return ServerResponse.createByErrorMessage("该用户未登录，无法获取当前用户的信息");
//        }
//        String userJsonStr = RedisShardedPoolUtil.get(loginToken);
//        User user = JsonUtil.string2Obj(userJsonStr, User.class);
//        if (user == null) {
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请登录");
//        }
//        if (iUserService.checkAdminRole(user).isSuccess()) {
//            //增加产品的业务逻辑
//            return iOrderService.manageDetail(orderNo);
//        } else {
//            return ServerResponse.createByErrorMessage("该用户没有权限");
//        }
        return iOrderService.manageDetail(orderNo);
    }

    /**
     * 按订单号搜索
     * @param orderNo
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("search.do")
    @ResponseBody
    public ServerResponse<PageInfo> orderSearch(HttpServletRequest request, Long orderNo,
                                      @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                      @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
//        String loginToken = CookieUtil.readLoginToken(request);
//        if (StringUtils.isEmpty(loginToken)) {
//            return ServerResponse.createByErrorMessage("该用户未登录，无法获取当前用户的信息");
//        }
//        String userJsonStr = RedisShardedPoolUtil.get(loginToken);
//        User user = JsonUtil.string2Obj(userJsonStr, User.class);
//        if (user == null) {
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请登录");
//        }
//        if (iUserService.checkAdminRole(user).isSuccess()) {
//            //增加产品的业务逻辑
//            return iOrderService.manageSearch(orderNo, pageNum, pageSize);
//        } else {
//            return ServerResponse.createByErrorMessage("该用户没有权限");
//        }
        return iOrderService.manageSearch(orderNo, pageNum, pageSize);
    }

    /**
     * 订单发货
     * @param orderNo
     * @return
     */
    @RequestMapping("send.do")
    @ResponseBody
    public ServerResponse<String> orderSendGoods(HttpServletRequest request, Long orderNo) {
//        String loginToken = CookieUtil.readLoginToken(request);
//        if (StringUtils.isEmpty(loginToken)) {
//            return ServerResponse.createByErrorMessage("该用户未登录，无法获取当前用户的信息");
//        }
//        String userJsonStr = RedisShardedPoolUtil.get(loginToken);
//        User user = JsonUtil.string2Obj(userJsonStr, User.class);
//        if (user == null) {
//            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登录，请登录");
//        }
//        if (iUserService.checkAdminRole(user).isSuccess()) {
//            //增加产品的业务逻辑
//            return iOrderService.manageSendGoods(orderNo);
//        } else {
//            return ServerResponse.createByErrorMessage("该用户没有权限");
//        }
        return iOrderService.manageSendGoods(orderNo);
     }
}
