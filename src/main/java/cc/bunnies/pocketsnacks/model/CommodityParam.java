package cc.bunnies.pocketsnacks.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommodityParam {
    private int paramId;                    //主键
    private String type;                    //产品类型
    private String productArea;             //原料产地
    private String productPlace;            //产地
    private String productSpecification;    //产品规格
    private String expirationDate;          //保质期
    private String usage;                   //使用方法
    private String storageMethod;           //储存方法
    private String standardNumber;          //产品标准号
    private String licenseNumber;           //生产许可证编号
}