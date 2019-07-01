package cc.bunnies.pocketsnacks.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private int uid;            //用户编号
    private String username;    //用户名
    private String password;    //密码
    private String phone;       //手机号码
    private String gender;      //性别
    private String email;       //邮箱
    private long regTime;       //注册时间
    private int accountId;      //账户编号
}