package com.mercury.laptapVS.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.laptapVS.bean.SavedProduct;


public interface SavedProductDao extends JpaRepository<SavedProduct,Integer>{

	public List<SavedProduct> findAllByUserId(int userId);
	
	public SavedProduct findByProductIdAndUserId(int productId,int UserId);

	

}
