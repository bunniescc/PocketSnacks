package cc.bunnies.pocketsnacks.dao;

import cc.bunnies.pocketsnacks.model.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AccountDao {

    @Insert("insert into tb_account(uid,money)values(#{uid},#{money})")
    @Options(useGeneratedKeys = true, keyProperty = "accountId")
    int createAccount(Account account);

    @Update("update tb_account set uid=#{uid},money=#{money} where accountId=#{accountId}")
    int updateAccount(Account account);

    @Delete("delete from tb_account where accountId=#{aid}")
    int deleteAccount(@Param("aid") int accountId);

    @Select("select * from tb_account where accountId=#{aid} limit 1")
    Account getAccountById(@Param("aid") int accountId);

    @Select("select * from tb_account")
    List<Account> getAllAccounts();

    @Select("select count(*) from tb_account")
    int getAccountCount();
}
