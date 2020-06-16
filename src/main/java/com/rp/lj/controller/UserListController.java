package com.rp.lj.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rp.lj.bean.UserList;
import com.rp.lj.service.UserListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

/**
 * @author lj
 * @time 2020/6/1
 */
@Controller
public class UserListController {
    
    @Autowired
    private UserListService userListService;
    
    @RequestMapping("userlist")
    @ResponseBody
    @CrossOrigin
    public Map selectAll(){
        Map map=new HashMap();
        PageHelper.startPage(1,5);
        List<UserList> lists = userListService.selectAll();
        PageInfo pageInfo=new PageInfo(lists);
        map.put("page",pageInfo);
        return map;
    }
    @RequestMapping("userinsert")
    public void insert() {
            UserList user=new UserList();
            UUID uuid=UUID.randomUUID();
            String sacc = uuid.toString().substring(0, 5);
            user.setId(null);
            user.setAccount(sacc);
            UUID uuid1=UUID.randomUUID();
            String sname = uuid1.toString().substring(0, 3);
            user.setName(sname);
            user.setRoles("普通用户");
            user.setCreatedate(new Date());
            user.setCurrenttime(new Date());
            user.setUserstatus("未在线");
            userListService.insert(user);
     }
    @RequestMapping("selectCondition")
    @ResponseBody
    @CrossOrigin
    public Map selectCondition(String name,String ro,String online){
        if (ro.equals("全部")) ro=null;
        if (online.equals("全部")) online=null;
        Map map=new HashMap();
        List<UserList> lists = userListService.selectByCondition(name,ro,online);
        if (lists.isEmpty()) map.put("msg","没有符合的人");
        else map.put("list",lists);
        return map;
    }

    @RequestMapping(value = "updateList/{map}",method= RequestMethod.PUT)
    @ResponseBody
    @CrossOrigin
    //@RequestBody Map<String,Object> param(接收json)
    public Map updateList(@PathVariable("map")String json) throws JsonProcessingException {
        Map map=new HashMap();
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> param= mapper.readValue(json, HashMap.class);
        UserList userList=new UserList();
        /*for (Map.Entry<String, Object> entry : readValue.entrySet()) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }*/
        userList.setId((Integer) param.get("id"));
        userList.setAccount((String) param.get("account"));
        userList.setName((String) param.get("name"));
        userList.setRoles((String) param.get("role"));
        userList.setUserstatus((String) param.get("userStatus"));
        String creDate = param.get("creDate").toString();
        long cDate = Long.parseLong(creDate);
        userList.setCreatedate(new Date(cDate));
        String currTime = param.get("currTime").toString();
        long curTime = Long.parseLong(currTime);
        userList.setCurrenttime(new Date(curTime));
        //System.out.println(userList);
        if(userListService.updateByPrimaryKeySelective(userList)) map.put("msg","编辑成功");
        else map.put("msg","编辑资料有误");
        return map;
    }

    @RequestMapping(value = "deleteList/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin
    public Map deleteList(@PathVariable("id")String id){
        System.out.println(id);
        Map<String,Object> map=new HashMap();
        boolean b = userListService.deleteByPrimaryKey(id);
        map.put("msg",b);
        return map;
    }
}
