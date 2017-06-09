package com.qcmall.order.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qcmall.order.dao.UserDAO;
import com.qcmall.order.domain.UserDO;

@Service("userService")
public class UserService{

    @Resource(name="userDAO")
    private UserDAO userDAO;

    public UserDO selectByPrimaryKey(String id) {
        return userDAO.selectByPrimaryKey(id);
    }

    public List<UserDO> queryAll() {
        return userDAO.queryAll();
    }
    
    public List<UserDO> queryList(Map<String,Object> param){
        return userDAO.queryList(param);
    }
    
    @Transactional
    public String insert(){
        UserDO ud = new UserDO();
        ud.setName("name"+System.currentTimeMillis());
        ud.setGmtCreated(new Date());
        int result = userDAO.insertSelective(ud);
        if(result<1){
            throw new RuntimeException();
        }
        return ud.getId();
    }
}
