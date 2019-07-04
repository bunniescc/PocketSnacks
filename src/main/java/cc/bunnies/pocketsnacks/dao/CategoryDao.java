package cc.bunnies.pocketsnacks.dao;

import cc.bunnies.pocketsnacks.model.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CategoryDao {
    @Insert("insert into tb_category(categoryParentId,name) values(#{categoryParentId},#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "categoryId")
    int create(Category category);

    @Update("update tb_category set categoryParentId=#{categoryParentId},name=#{name} where categoryId=#{categoryId}")
    int update(Category category);

    @Delete("delete from tb_category where categoryId=#{cid}")
    int delete(@Param("cid") int cid);

    @Select("select c.category_id,c.category_parent_id,c.name ,p.name as parent from tb_category as c join tb_category as p on p.category_id = c.category_parent_id limit #{st},#{size};")
    List<Category> getCategoriesByWithParent(@Param("st") int start, @Param("size") int size);

    @Select("select count(*) from tb_category as c join tb_category as p on p.category_id = c.category_parent_id;")
    int getCountWithParent();
}