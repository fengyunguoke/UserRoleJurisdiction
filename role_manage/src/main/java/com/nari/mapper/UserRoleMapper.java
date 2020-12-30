package com.nari.mapper;

import com.nari.pojo.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserRoleMapper {

    List<UserRole> getAllUserRole();

    int checkUserRole(int userId);

    int addUserRole(UserRole userRole);

    UserRole getUserRoleById(int userId);

    int alterUserRole(UserRole userRole);



}
