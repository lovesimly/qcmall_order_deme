package com.qcmall.order.dao;


import java.util.List;
import java.util.Map;

import com.qcmall.order.domain.UserDO;


public interface UserDAO {

    int deleteByPrimaryKey(String id);

    int insertSelective(UserDO record);

    UserDO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserDO record);
    
    List<UserDO> queryAll();
    
    List<UserDO> queryList(Map<String,Object> param);
}