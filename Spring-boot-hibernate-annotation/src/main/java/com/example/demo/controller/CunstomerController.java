package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TODO: comment here
 */
@RestController
public class CunstomerController {
	private Gson gson = new Gson();

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET)
	public String getAllCustomers() {

		List<Customer> listOfCustomers = customerService.getAllCustomers();
		String jsonStr = gson.toJson(listOfCustomers);
		System.out.println("Result:\t" + jsonStr);
		return jsonStr;
	}

}
