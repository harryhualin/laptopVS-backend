package com.mercury.laptapVS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.laptapVS.bean.SavedProduct;
import com.mercury.laptapVS.dao.SavedProductDao;
import com.mercury.laptapVS.http.DataResponse;
import com.mercury.laptapVS.http.Response;

@Service
public class SavedProductService {
	@Autowired
	private SavedProductDao savedProductDao;
	
	public List<SavedProduct> getAllByUserId(int UserId){
		return savedProductDao.findAllByUserId(UserId);
	}
	
	public DataResponse<SavedProduct> Save(SavedProduct savedProduct) {
		boolean isSaved=this.isSaved(savedProduct.getProduct().getId(), savedProduct.getUserId());
			if(isSaved) return new DataResponse<SavedProduct>(true,"product already be saved");
			else return new DataResponse<SavedProduct>(true,200,"product saved",savedProductDao.save(savedProduct));	
	}
	
	public  DataResponse<SavedProduct> delete(int id) {
		SavedProduct item=savedProductDao.findById(id).get();
		if(item!= null) {
			savedProductDao.deleteById(item.getId());
			return new DataResponse<SavedProduct>(true,200,"delete savedProduct id"+ id,item);
		}else {
			return new DataResponse<SavedProduct>(false,400,"savedProduct is not found!");
		}
		
	}

	public boolean isSaved(int productId,int userId) {
		SavedProduct savedProduct=savedProductDao.findByProductIdAndUserId(productId, userId);
		System.out.print(savedProduct);
		if (savedProduct==null) return false;
		else return true;
	}

	public Response deleteByProductIdAndUserId(int productId, int userId) {
		SavedProduct item=savedProductDao.findByProductIdAndUserId(productId,userId);
		if(item!= null) {
			savedProductDao.deleteById(item.getId());
			return new Response(true,"delete savedProduct for productId "+productId+" with userId "+userId);
		}else {
			return new Response(false, "savedProduct is not found!");
		}
		
	}
	
}
