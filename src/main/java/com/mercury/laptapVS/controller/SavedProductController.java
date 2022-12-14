package com.mercury.laptapVS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.laptapVS.bean.SavedProduct;
import com.mercury.laptapVS.http.DataResponse;
import com.mercury.laptapVS.http.Response;
import com.mercury.laptapVS.service.SavedProductService;

@RestController
@RequestMapping("/SavedProduct")
public class SavedProductController {
	@Autowired
	private SavedProductService savedProductService;
	
	
	@GetMapping("/{userId}")
	public DataResponse<SavedProduct> getAll(@PathVariable int userId) {
		return new DataResponse<SavedProduct>(true,200,"get savedpProducts for useID"+ userId,savedProductService.getAllByUserId(userId));
	}
	
	@PostMapping
	public DataResponse<SavedProduct> add(@RequestBody SavedProduct savedProduct) {
		return savedProductService.Save(savedProduct);
	}
	
	@DeleteMapping("/{id}")
	public Response delete(@PathVariable int id) {
		return savedProductService.delete(id);
	}
	
	@DeleteMapping("/{productId}/{userId}")
	public Response deleteByProductIdAndUserId(@PathVariable int productId,@PathVariable int userId) {
		return savedProductService.deleteByProductIdAndUserId(productId,userId);
	}
	
	@GetMapping("/{productId}/{userId}")
	public Response isSaved(@PathVariable int productId,@PathVariable int userId) {
		boolean isSaved=savedProductService.isSaved(productId,userId);
		return new Response(isSaved,"prodcutId "+productId+" is saved by userId"+userId);
	}
	
}
