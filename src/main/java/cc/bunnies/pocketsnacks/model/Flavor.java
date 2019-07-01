package cc.bunnies.pocketsnacks.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Flavor {
    private int fid;        //口味编号，主键，自动增长
    private String name;    //口味名称
}