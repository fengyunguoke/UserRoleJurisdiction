package com.nari.mapper;

import com.nari.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleMapper {

    //查询所有角色
    List<Role> getAllRole();

    //增加角色
    int addRole(Role role);

}
