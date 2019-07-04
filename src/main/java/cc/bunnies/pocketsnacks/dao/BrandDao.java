package cc.bunnies.pocketsnacks.dao;

import cc.bunnies.pocketsnacks.model.Brand;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface BrandDao {
    @Insert("insert into tb_brand(name,phone,email,address,state)values(#{name},#{phone},#{email},#{address},#{state})")
    @Options(useGeneratedKeys = true, keyProperty = "brandId")
    int create(Brand brand);

    @Update("update tb_brand set name=#{name},phone=#{phone},email=#{email},address=#{address},state=#{state} where brandId=#{brandId}")
    int update(Brand brand);

    @Delete("delete from tb_brand where brandId=#{bid}")
    int delete(@Param("bid") int brandId);

    @Select("select * from tb_brand limit #{st},#{size}")
    List<Brand> getBrandsByPage(@Param("st") int start, @Param("size") int size);

    @Select("select * from tb_brand where brandId=#{bid}")
    Brand getBrandById(@Param("bid") int brandId);

    @Select("select count(*) from tb_brand")
    int getCount();
}
