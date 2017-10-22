package com.example.tx.web;

import com.example.tx.entity.Account;
import com.example.tx.entity.Stock;
import com.example.tx.mapper.SpringMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * TODO: comment here
 */
@RestController
public class ShopController {

	@Autowired
	private SpringMapper springMapper;

	@Transactional
	@RequestMapping("/purchase")
	public String purchase() throws Exception {
		System.out.println("purchase ...........");

		int price = springMapper.findBookPriceByIsbn("1001");
		int stock = springMapper.getStockByIsbn("1001");

		System.out.println("price: " + price + "  :  stock: " + stock);
		if(stock < 1){
			throw new Exception("库存不够");
		}

		stock = stock - 1;
		Stock stockObj = new Stock();
		stockObj.setIsbn("1001");
		stockObj.setStock(stock);
		springMapper.updateStockByIsbn(stockObj);

		System.out.println("更新库存完事");

		if(stock > 0){
			throw new UserAccountException("余额不足!");
		}

		int balance = 108;
		Account account = new Account();
		account.setBalance(balance);
		account.setUsername("AA");
		springMapper.updataBalanceByUsername(account);

		return "failed";
	}
}
