package cc.bunnies.pocketsnacks.dao;

import cc.bunnies.pocketsnacks.model.Category;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CategoryDao {
    @Insert("insert into tb_category(categoryParentId,name) values(#{categoryParentId},#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "categoryId")
    int create(Category category);

    @Update("update tb_category set categoryParentId=#{categoryParentId},name=#{name} where categoryId=#{categoryId}")
    int update(Category category);

    @Delete("delete from tb_category where categoryId=#{cid}")
    int delete(@Param("cid") int cid);
}
