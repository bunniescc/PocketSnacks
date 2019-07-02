package cc.bunnies.pocketsnacks.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class Order {
    private String oid;             //订单编号，主键
    private int uid;                //用户编号(外键)
    private double totalPrice;      //总价
    private String remark;          //备注
    private Timestamp orderTime;    //下单时间
    private int state;              //订单状态：0:待付款  1:待发货  2:待收货 3:待评价
    private int addressId;          //地址编号
}