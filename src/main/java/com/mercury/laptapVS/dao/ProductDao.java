package com.mercury.laptapVS.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.laptapVS.bean.Product;

public interface ProductDao extends JpaRepository<Product,Integer>{
	
}
