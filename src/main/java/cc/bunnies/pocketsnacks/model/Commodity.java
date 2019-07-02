package cc.bunnies.pocketsnacks.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class Commodity {
    private int commodityId;            //商品编号，主键，自动增长
    private int categoryId;             //类别编号
    private int brandId;                //品牌编号
    private String name;                //商品名称
    private double promotionalPrice;    //促销价
    private double originalPrice;       //原价
    private String description;         //商品描述
    private String img;                 //商品图片名
    private Timestamp createTime;       //创建时间
    private int paramId;                //产品参数
    private String brandName;           //品牌名称
    private String categoryName;        //类型名称
}