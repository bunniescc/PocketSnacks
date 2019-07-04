package cc.bunnies.pocketsnacks.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDetail {
    private int detailId;       //编号，主键自动增长
    private int commodityId;    //商品编号(外键)
    private int quantity;       //商品数量
    private double price;       //单价
    private int fid;            //口味编号(外键)
    private int brandId;        //品牌编号(外键)
    private String oid;         //订单编号
    private String commodityName;
    private int state;          //订单状态：0:待付款  1:待发货  2:待收货 3:待评价
}