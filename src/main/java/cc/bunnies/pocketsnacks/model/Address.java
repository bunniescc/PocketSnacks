package cc.bunnies.pocketsnacks.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private int addressId;          //地址编号，主键，自动增长
    private int uid;                //用户编号(外键)
    private String fullAddress;     //详细地址
    private String phone;           //联系电话
    private String zipCode;         //邮编
    private String name;            //联系人姓名
    private int state;              //状态1:默认 0:非默认
}