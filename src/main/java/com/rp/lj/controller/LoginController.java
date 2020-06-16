package com.rp.lj.controller;

import com.rp.lj.bean.Login;
import com.rp.lj.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lj
 * @time 2020/5/31
 */
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping(value = "login",method= RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Map login(String uname, String upwd){
        List<Login> logins=loginService.getLogins();
        Map info=new HashMap<>();
        for(Login login : logins ){
           // System.out.println(login);
            if(login.getAccount().equals(uname))
            {
                info.put("mgs","有此账号");
                if(login.getAccount().equals(uname)&&login.getAccPwd().equals(upwd)) {info.put("mgs","登录成功");info.put("uanme",uname);break;}
                else if(login.getAccount().equals(uname)&& !login.getAccPwd().equals(upwd)) {
                Login login1 = new Login();
                if (login.getCount()==null) {
                    login1.setCount(1);
                    login1.setAccount(uname);
                    loginService.updateByPrimaryKeySelective(login1);
                    info.put("mgs","账号或密码不正确，还有"+(3-login1.getCount())+"次机会");
                    break;
                    }
                else {
                      if(login.getCount()<3)
                       { login1.setCount(login.getCount()+1);
                           System.out.println("*******"+login1.getCount());
                           login1.setAccount(uname);
                           loginService.updateByPrimaryKeySelective(login1);
                           info.put("mgs","账号或密码不正确，还有"+(3-login1.getCount())+"次机会");
                           break;}
                       else info.put("mgs","密码错误3次以上，若忘记密码，请联系管理员修改密码");break;
                     }
                }
            }
            else {info.put("mgs","无此账号");continue;}
            }
        return info;
    }
    
   /* @RequestMapping("insert")
    public void insert(){
        Login login = new Login();
        login.setCount(1);
        login.setAccount("xxxLIJUN");
        login.setAccPwd("123456");
        loginService.insertSelective(login);
    }
    @RequestMapping("update")
    public void update(){
        Login login = new Login();
        login.setCount(3);
        login.setAccount("xxxLIJUN");
        loginService.updateByPrimaryKeySelective(login);
    }*/
}
