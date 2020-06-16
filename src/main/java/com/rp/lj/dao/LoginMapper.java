package com.rp.lj.dao;

import com.rp.lj.bean.Login;
import com.rp.lj.bean.LoginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoginMapper {
    long countByExample(LoginExample example);

    int deleteByExample(LoginExample example);

    int insert(Login record);

    int insertSelective(Login record);

    List<Login> selectByExample(LoginExample example);

    int updateByExampleSelective(@Param("record") Login record, @Param("example") LoginExample example);
    
    int updateByPrimaryKeySelective(Login login);
    
    Login selectOneByPrimaryKey(String Primkey);

    int updateByExample(@Param("record") Login record, @Param("example") LoginExample example);
}