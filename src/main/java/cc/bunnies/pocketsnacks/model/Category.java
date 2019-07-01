package cc.bunnies.pocketsnacks.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Category {
    private int categoryId;         //分类编号，主键，自动增长
    private int categoryParentId;   //父级编号
    private String name;            //类别名称
}