package cc.bunnies.pocketsnacks.dao;

import cc.bunnies.pocketsnacks.model.Commodity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CommodityDao {
    @Select("select  c.*,b.name brand_name ,ca.name category_name from tb_commodity c inner join tb_brand b on b.brand_id = c.brand_id inner join tb_category ca on ca.category_id = c.category_id limit #{st},#{size}")
    List<Commodity> getCommoditiesByPage(@Param("st") int start, @Param("size") int size);

    @Select("select count(*) from tb_commodity")
    int getCount();
}
