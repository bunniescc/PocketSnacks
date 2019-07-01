package cc.bunnies.pocketsnacks.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Brand {
    private int brandId;    //商家编号，主键，自动增长
    private String name;    //联系人姓名
    private String phone;   //电话
    private String email;   //邮箱
    private String address; //公司详细地址
    private String state;   //状态0:合作  1:取消合作
}