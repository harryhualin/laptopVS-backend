package com.mercury.laptapVS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.laptapVS.bean.Product;
import com.mercury.laptapVS.bean.Rate;
import com.mercury.laptapVS.dao.ProductDao;
import com.mercury.laptapVS.http.DataResponse;


@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	@Autowired
	private RateService rateService;
	
	public List<Product> getAll(){
        try {
            List<Product> products = productDao.findAll();
            products.forEach((product) -> {
                // enrich the product object
                Rate rate= rateService.getByProductIdWithUserId(product.getId(), 0);
               product.setRate(rate);
             
            });
            
            return products;
        } catch (Exception e) {
           
        	return  productDao.findAll();
        }
		
	
		
	}
	
	public Product getProductById(int id) {
		Product product=productDao.findById(id).get();
		if(product!=null) {
			product.setViews(product.getViews()+1);
			product= productDao.save(product);
			Rate rate= rateService.getByProductIdWithUserId(product.getId(), 0);
            product.setRate(rate); 
				return product;
		}
		
		return product;
	}

	public DataResponse<Product> save(Product product) {
		 try {
	            
	            return new DataResponse<Product>(true,200,"save product success",productDao.save(product));
	        } catch (Exception e) {
	           
	        	return new DataResponse<Product>(false,"save product failed");
	        }
			
	}

	
}
