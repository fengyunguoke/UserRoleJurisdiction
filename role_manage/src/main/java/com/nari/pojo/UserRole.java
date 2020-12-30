package com.nari.pojo;

public class UserRole {

    private int userId;
    private int roleId;
    private int userRoleId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public UserRole(){}

    public UserRole(int userId, int roleId, int userRoleid) {
        this.userId = userId;
        this.roleId = roleId;
        this.userRoleId = userRoleid;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                ", userRoleId=" + userRoleId +
                '}';
    }
}
