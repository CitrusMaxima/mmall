package com.mmall.controller.backend;

import com.google.common.collect.Lists;
import com.mmall.common.ServerResponse;
import com.mmall.service.IOrderService;
import com.mmall.service.IProductService;
import com.mmall.service.IUserService;
import com.mmall.service.impl.UserServiceImpl;
import com.mmall.vo.ManageCountVo;
import net.sf.jsqlparser.schema.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/manage/statistic")
public class ManageController {
    
    @Autowired
    IUserService iUserService;
    
    @Autowired
    IProductService iProductService;
    
    @Autowired
    IOrderService iOrderService;

    @RequestMapping(value = "/base_count.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<ManageCountVo> baseCount() {
        int userCount = iUserService.getUserCount();
        int productCount = iProductService.getProductCount();
        int orderCount = iOrderService.getOrderCount();

        ManageCountVo manageCountVo = new ManageCountVo();

        manageCountVo.setUserCount(userCount);
        manageCountVo.setProductCount(productCount);
        manageCountVo.setOrderCount(orderCount);
        
        return ServerResponse.createBySuccess(manageCountVo);
    }

}
