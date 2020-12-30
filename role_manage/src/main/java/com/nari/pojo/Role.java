package com.nari.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer roleId;
    private String roleName;
    private String roleComment;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleComment() {
        return roleComment;
    }

    public void setRoleComment(String roleComment) {
        this.roleComment = roleComment;
    }

    public Role(){

    }

    public Role(Integer id, String roleName, String comments) {
        this.roleId = id;
        this.roleName = roleName;
        this.roleComment = comments;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", comments='" + roleComment + '\'' +
                '}';
    }
}
