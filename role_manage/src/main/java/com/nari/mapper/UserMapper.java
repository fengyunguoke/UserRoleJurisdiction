package com.nari.mapper;

import com.nari.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<User> getAllUser();

    int addUser(User user);

    int deleteUser(int userId);
}
