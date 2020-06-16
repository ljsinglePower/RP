package com.rp.lj.controller;

import com.rp.lj.bean.Login;
import com.rp.lj.bean.UserList;
import com.rp.lj.service.ConcatService;
import com.rp.lj.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ConcatController {
    @Autowired
    private ConcatService concatService;
    @RequestMapping(value = "insertUser",method= RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    //@RequestBody Map<String,Object> param(接收json)
    public Map insert(@RequestBody Map<String,Object> param){
        System.out.println(param.toString());
        Map map=new HashMap();
        Login login=new Login();
        login.setAccount((String) param.get("account"));
        login.setAccPwd((String) param.get("pwd"));
        login.setCount(null);
        UserList userList=new UserList();
        userList.setId(null);
        userList.setAccount((String) param.get("account"));
        userList.setName((String) param.get("name"));
        userList.setRoles((String) param.get("role"));
        userList.setUserstatus("在线");
        userList.setCreatedate(new Date());
        userList.setCurrenttime(new Date());
        boolean b=concatService.insertComit(login,userList);
        map.put("msg",b);
        return map;
    }
}
