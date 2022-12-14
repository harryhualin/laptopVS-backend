package com.mercury.laptapVS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.laptapVS.bean.Rate;
import com.mercury.laptapVS.dao.RateDao;
import com.mercury.laptapVS.http.DataResponse;
@Service

public class RateService {
	
	@Autowired RateDao rateDao;
	
	public Rate getByProductIdWithUserId(int productId,int userId) {
		if (userId==0)   /// not login user
		{
			List<Rate> rateList=rateDao.findAllByProductId(productId);
			float total=rateList.stream().map(x->x.getRate()).reduce((int)0,(x,y)->x+y);
			Rate rate=new Rate();
			rate.setProductId(productId);
			if(rateList.size()>0) {rate.setRate((int) (total/rateList.size()));}
			else rate.setRate(0);
			return rate;
		}
		else {
			Rate myRate=rateDao.findByProductIdAndUserId(productId,userId);
			if (myRate==null) {
				myRate=new Rate();
				myRate.setProductId(productId);
				myRate.setRate(0);
				myRate.setUserId(userId);
				}
			return myRate;
		}
	}

	public DataResponse<Rate> save(Rate rate) {
		Rate existing=rateDao.findByProductIdAndUserId(rate.getProductId(), rate.getUserId());
		if(existing!=null) {		
			existing.setRate(rate.getRate());
		}
		else{existing=rate;}
		
		return new DataResponse<Rate>(true,200,"save a rate a Product",rateDao.save(existing));
		
	}


}
