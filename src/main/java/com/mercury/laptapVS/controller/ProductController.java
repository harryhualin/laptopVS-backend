package com.mercury.laptapVS.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.laptapVS.bean.Product;
import com.mercury.laptapVS.http.DataResponse;
import com.mercury.laptapVS.service.ProductService;
import com.mercury.laptapVS.service.RateService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@PreAuthorize("permitAll()")
	@GetMapping
	public DataResponse<Product> getAll(){
		List<Product> dataList=productService.getAll();
		return new DataResponse<Product>(true,200,"Get products succeed",dataList);
	}
	
	@PreAuthorize("permitAll()")
	@GetMapping("/{id}")
	public DataResponse<Product> getProductById(@PathVariable int id){
		List<Product> dataList=new ArrayList<Product>();
		dataList.add(productService.getProductById(id));
		return new DataResponse<Product>(true,200,"Get product by id: "+id,dataList);
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@PostMapping
	public DataResponse<Product> add(@RequestBody Product product){
		
		return productService.save(product);
	}
	
	
}
