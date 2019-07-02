package cc.bunnies.pocketsnacks.dao;

import cc.bunnies.pocketsnacks.model.Cart;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CartDao {
    @Insert("insert into tb_cart(uid,quantity,fid,commodityId)values(#{uid},#{quantity},#{fid},#{commodityId})")
    @Options(useGeneratedKeys = true, keyProperty = "cartId")
    int create(Cart cart);

    @Update("update tb_cart set uid=#{uid},quantity=#{quantity},fid=#{fid},commodityId=#{commodityId} where cartId=#{cartId}")
    int update(Cart cart);

    @Delete("delete from tb_cart where cartId=#{cid}")
    int delete(@Param("cid") int cid);

    @Delete("delete from tb_cart where uid=#{uid}")
    int deleteByUid(@Param("uid") int uid);

    @Select("select * from tb_cart where cartId=#{cid}")
    Cart getCartById(@Param("cid") int cartId);

    @Select("select * from tb_cart where uid=#{uid}")
    List<Cart> getCartsByUid(@Param("uid") int uid);
}
