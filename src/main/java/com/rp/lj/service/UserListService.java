package com.rp.lj.service;

import com.rp.lj.bean.UserList;
import com.rp.lj.bean.UserListExample;
import com.rp.lj.dao.UserListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lj
 * @time 2020/6/1
 */
@Service
public class UserListService {
    //增加
    @Autowired
    private UserListMapper userListMapper;
    public  int insert(UserList userList){
        int result= userListMapper.insert(userList);
        return  result;
    }
    
    public List<UserList> selectAll(){
        List<UserList> userLists = userListMapper.selectByExample(null);
        return userLists;
    }
    
    public List<UserList> selectByCondition(String account,String roles,String userStatus){
        List<UserList> userLists = userListMapper.selectByCondition(account,roles,userStatus);
        return userLists;
    }

    public boolean updateByPrimaryKeySelective(UserList record){
        int i = userListMapper.updateByPrimaryKeySelective(record);
        return i>0;
    }

    public boolean deleteByPrimaryKey(String id){
        int i = userListMapper.deleteByPrimaryKey(Integer.parseInt(id));
        return i>0;
    }
}
