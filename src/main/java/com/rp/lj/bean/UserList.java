package com.rp.lj.bean;

import java.util.Date;

public class UserList {
    private Integer id;

    private String account;

    private String name;

    private String roles;

    private Date createdate;

    private Date currenttime;

    private String userstatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles == null ? null : roles.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getCurrenttime() {
        return currenttime;
    }

    public void setCurrenttime(Date currenttime) {
        this.currenttime = currenttime;
    }

    public String getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(String userstatus) {
        this.userstatus = userstatus == null ? null : userstatus.trim();
    }

    @Override
    public String toString() {
        return "UserList{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", roles='" + roles + '\'' +
                ", createdate=" + createdate +
                ", currenttime=" + currenttime +
                ", userstatus='" + userstatus + '\'' +
                '}';
    }
}