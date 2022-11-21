package com.mercury.laptapVS.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.laptapVS.bean.Rate;

public interface RateDao extends JpaRepository<Rate,Integer> {

	public List<Rate> findAllByProductId(int productId);

	public Rate findByProductIdAndUserId(int productId, int userId);


}
 