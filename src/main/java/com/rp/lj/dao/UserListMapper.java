package com.rp.lj.dao;

import com.rp.lj.bean.UserList;
import com.rp.lj.bean.UserListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserListMapper {
    long countByExample(UserListExample example);

    int deleteByExample(UserListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserList record);

    int insertSelective(UserList record);

    List<UserList> selectByExample(UserListExample example);

    UserList selectByPrimaryKey(Integer id);
    
    List<UserList>  selectByCondition(@Param("account")String account,@Param("roles")String roles,@Param("userStatus")String userStatus);

    int updateByExampleSelective(@Param("record") UserList record, @Param("example") UserListExample example);

    int updateByExample(@Param("record") UserList record, @Param("example") UserListExample example);

    int updateByPrimaryKeySelective(@Param("record")UserList record);

    int updateByPrimaryKey(UserList record);
}