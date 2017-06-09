package com.qcmall.order.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qcmall.order.base.PageInfo;
import com.qcmall.order.domain.UserDO;
import com.qcmall.order.service.UserService;

@Controller
public class UserController {

	@Resource(name="userService")
	private UserService userService;
	
    @RequestMapping("/userList")
    public String list(ModelMap model) {
        model.put("users", userService.queryAll());
        return "user/list";
    }
    
    @RequestMapping("/userPageList/{currentPage}/{pageSize}")
    public String pageList(@PathVariable(value = "currentPage") String currentPage,@PathVariable(value = "pageSize") String pageSize,ModelMap model) {
        Map<String,Object> param = new HashMap<String,Object>();
        PageInfo page = new PageInfo();
        page.setCurrentPage(currentPage);
        page.setPageSize(pageSize);
        param = page.toQueryMap();
        model.put("users", userService.queryList(param));
        page.setTotalItem(3);//总条数
        model.put("page", page);
        return "user/list";
    }
    
    @RequestMapping("/user/{id}")
    public String detail(@PathVariable(value = "id") String id, ModelMap model,HttpServletRequest request) {
        model.put("user", userService.selectByPrimaryKey(id));
        return "user/detail";
    }
    
    @RequestMapping("/user/add")
    public String insert(UserDO user,ModelMap model){
        try{
            String id = userService.insert();
            model.put("user", userService.selectByPrimaryKey(id));
        }catch(RuntimeException e){
            return "error";
        }
        return "user/detail";
    }

}