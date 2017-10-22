package com.example.tx.mapper;

import com.example.tx.entity.Account;
import com.example.tx.entity.Stock;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * TODO: comment here
 */
public interface SpringMapper{

	@Select("SELECT price FROM book WHERE isbn = #{isbn}")
	int findBookPriceByIsbn(String isbn);

	@Select("SELECT stock FROM book_stock WHERE isbn = #{isbn}")
	int getStockByIsbn(String isbn);

	@Update("UPDATE book_stock SET stock = #{stock} WHERE isbn = #{isbn}")
	void updateStockByIsbn(Stock stockObj);

	@Select("SELECT balance FROM account WHERE username=${username}")
	int getBalanceByUsername(String username);

	@Update("UPDATE account SET balance=#{balance} WHERE username=#{username}")
	void updataBalanceByUsername(Account account);
}
