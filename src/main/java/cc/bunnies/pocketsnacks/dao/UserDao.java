package cc.bunnies.pocketsnacks.dao;

import cc.bunnies.pocketsnacks.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserDao {
    @Select("select * from user")
    List<User> getAllUser();

    @Select("select * from user where username = #{username} limit 1")
    User getUserByUsername(@Param("username") String username);

    @Insert("insert into user(username,password) values (#{username},#{password})")
    @Options(useGeneratedKeys = true, keyProperty = "uid")
    int insert(User user);
}
