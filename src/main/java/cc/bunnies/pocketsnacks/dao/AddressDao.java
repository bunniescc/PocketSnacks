package cc.bunnies.pocketsnacks.dao;

import cc.bunnies.pocketsnacks.model.Address;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AddressDao {
    @Insert("insert into tb_address(uid,fullAddress,phone,zipCode,name,state)values(#{uid},#{fullAddress},#{phone},#{zipCode},#{name},#{state})")
    @Options(useGeneratedKeys = true, keyProperty = "addressId")
    int createAddress(Address address);

    @Update("update tb_address set fullAddress=#{fullAddress},phone=#{phone},zipCode=#{zipCode},name=#{name},state=#{state} where addressId=#{addressId}")
    int updateAddress(Address address);

    @Delete("delete from tb_address where addressId=#{aid}")
    int deleteAddress(@Param("aid") int addressId);

    @Select("select * from tb_address where addressId=#{aid} limit 1")
    Address getAddressById(@Param("aid") int addressId);

    @Select("select * from tb_address")
    List<Address> getAllAddresses();

    @Select("select count(*) from tb_address")
    int getAddressCount();
}
