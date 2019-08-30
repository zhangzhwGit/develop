package com.zzw.login.pojo;

public class SysUser {
    private Integer userId;

    private String userName;

    private String nickName;

    private String password;

    private String authSalt;

    private Integer suthSaltNum;

    private Byte status;

    private String remark;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAuthSalt() {
        return authSalt;
    }

    public void setAuthSalt(String authSalt) {
        this.authSalt = authSalt == null ? null : authSalt.trim();
    }

    public Integer getSuthSaltNum() {
        return suthSaltNum;
    }

    public void setSuthSaltNum(Integer suthSaltNum) {
        this.suthSaltNum = suthSaltNum;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}