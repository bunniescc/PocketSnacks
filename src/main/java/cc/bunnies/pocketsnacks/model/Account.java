package cc.bunnies.pocketsnacks.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {
    private int accountId;      //账户编号，主键，自动增长
    private int uid;            //用户编号(外键)
    private double money;       //账户金额
}