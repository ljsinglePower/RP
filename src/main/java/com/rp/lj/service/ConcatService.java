package com.rp.lj.service;

import com.rp.lj.bean.Login;
import com.rp.lj.bean.UserList;
import com.rp.lj.dao.LoginMapper;
import com.rp.lj.dao.UserListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConcatService {
    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private UserListMapper userListMapper;
    @Transactional(rollbackFor = Exception.class)
    public boolean insertComit(Login login, UserList userList){
        int result = loginMapper.insertSelective(login);
        int result1 = userListMapper.insertSelective(userList);
        int i = 1 / 0;
        return result1>0&&result>0;
    }
}
