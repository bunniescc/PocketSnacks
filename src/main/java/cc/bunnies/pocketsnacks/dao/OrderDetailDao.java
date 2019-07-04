package cc.bunnies.pocketsnacks.dao;

import cc.bunnies.pocketsnacks.model.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface OrderDetailDao {
    @Select("select od.*,c.name as commodity_name,o.state as state from tb_order_detail as od inner join tb_commodity as c on c.commodity_id = od.commodity_id inner join tb_order as o on o.oid = od.oid limit #{st},#{size}")
    List<OrderDetail> getOrderDetailsByPage(@Param("st") int start, @Param("size") int size);

    @Select("select count(*) from tb_order_detail")
    int getCount();
}
