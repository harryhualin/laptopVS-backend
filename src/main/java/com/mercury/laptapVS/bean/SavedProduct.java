package com.mercury.laptapVS.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MSI_SAVED_PRODUCT")
public class SavedProduct {
	@Id
	@SequenceGenerator(name="msi_saved_product_seq_gen",sequenceName="msi_saved_product_seq",allocationSize=1)
	@GeneratedValue(generator="msi_saved_product_seq_gen",strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private int userId;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.DETACH)
	private Product product;

	public SavedProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SavedProduct(int id, int userId, Product product) {
		super();
		this.id = id;
		this.userId = userId;
		this.product = product;
	}

	
	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "SavedProduct [id=" + id + ", userId=" + userId + ", product=" + product + "]";
	}

		

	
	
}
