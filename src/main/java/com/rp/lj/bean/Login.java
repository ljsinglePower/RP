package com.rp.lj.bean;

public class Login {
    private String account;

    private String accPwd;

    private Integer count;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getAccPwd() {
        return accPwd;
    }

    public void setAccPwd(String accPwd) {
        this.accPwd = accPwd == null ? null : accPwd.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
    
    @Override
    public String toString() {
        return "Login{" +
                "account='" + account + '\'' +
                ", accPwd='" + accPwd + '\'' +
                ", count=" + count +
                '}';
    }
}