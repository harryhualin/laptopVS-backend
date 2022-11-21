package com.mercury.laptapVS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.laptapVS.bean.Rate;
import com.mercury.laptapVS.http.DataResponse;
import com.mercury.laptapVS.service.RateService;

@RestController
@RequestMapping("/rate")
public class RateController {
	@Autowired
	private RateService rateService;
	
	@GetMapping("/{productId}/{userId}")
	public DataResponse<Rate> getRateByProductId(@PathVariable int productId,@PathVariable int userId) {
		return new DataResponse<Rate>(true,200,"get rate for productId "+productId+" with userId "+userId,rateService.getByProductIdWithUserId(productId,userId));
	}
	
	@PostMapping
	public DataResponse<Rate> save(@RequestBody Rate rate) {	
		return rateService.save(rate);
	}
	
	
}
