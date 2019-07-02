package cc.bunnies.pocketsnacks.dao;

import cc.bunnies.pocketsnacks.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserDao {
    @Select("select * from tb_user")
    List<User> getAllUser();

    @Select("select * from tb_user where username=#{username} limit 1")
    User getUserByUsername(@Param("username") String username);

    @Select("select * from tb_user where uid=#{uid}")
    User getUserByUid(@Param("uid") int uid);

    @Insert("insert into tb_user(username,password,regTime) values (#{username},#{password},#{regTime})")
    @Options(useGeneratedKeys = true, keyProperty = "uid")
    int create(User user);

    @Update("update tb_user set username=#{username},password=#{password},phone=#{phone},gender=#{gender},email=#{email} where uid=#{uid}")
    int update(User user);

    @Delete("delete from tb_user where uid=#{uid}")
    int delete(@Param("uid") int uid);

    @Select("select count(*) from tb_user")
    int getCount();
}
