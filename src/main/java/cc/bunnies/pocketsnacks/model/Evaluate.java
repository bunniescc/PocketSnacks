package cc.bunnies.pocketsnacks.model;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class Evaluate {
    private int eid;                //编号，主键自动增长
    private int uid;                //用户编号(外键)
    private String oid;             //订单编号(外键)
    private Timestamp createTime;   //评论时间
    private String content;         //内容
}