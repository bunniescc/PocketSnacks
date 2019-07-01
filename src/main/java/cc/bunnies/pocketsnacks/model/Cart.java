package cc.bunnies.pocketsnacks.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cart {
    private int cartId;         //购物车编号，主键，自动增长
    private int uid;            //用户编号(外键)
    private int quantity;       //商品名数量
    private int fid;            //口味编号
    private int commodityId;    //商品编号
}