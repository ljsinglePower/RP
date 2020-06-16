package com.rp.lj.service;

import com.rp.lj.bean.Login;
import com.rp.lj.dao.LoginMapper;
import com.rp.lj.dao.UserListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lj
 * @time 2020/5/31
 */
@Service
public class LoginService {
    @Autowired
    private LoginMapper loginMapper;
    
    public List<Login> getLogins(){
        List<Login> logins =loginMapper.selectByExample (null);
        return logins;
    }
    public Login selectOneByPrimaryKey(String Primkey){
        Login login= loginMapper.selectOneByPrimaryKey(Primkey);
        return login;
    }
    
    public int insertSelective(Login record){
        int result = loginMapper.insertSelective(record);
        return result;
    }
    public int updateByPrimaryKeySelective(Login login){
        int i = loginMapper.updateByPrimaryKeySelective(login);
        return i;
    }
}
