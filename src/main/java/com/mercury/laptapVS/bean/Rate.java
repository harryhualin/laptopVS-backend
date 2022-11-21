package com.mercury.laptapVS.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="MSI_RATE")
public class Rate {
		@Id
		@SequenceGenerator(name="msi_rate_seq_gen",sequenceName="msi_rate_seq",allocationSize=1)
		@GeneratedValue(generator="msi_rate_seq_gen",strategy=GenerationType.AUTO)
		private int id;
		
		@Column
		private int productId;
		@Column
		private int userId;
		@Column
		private int rate;
	
		
		public Rate() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Rate(int id, int pruductId, int userId, int rate, Date date) {
			super();
			this.id = id;
			this.productId = pruductId;
			this.userId = userId;
			this.rate = rate;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getProductId() {
			return productId;
		}
		public void setProductId(int pruductId) {
			this.productId = pruductId;
		}
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public int getRate() {
			return rate;
		}
		public void setRate(int rate) {
			this.rate = rate;
		}
	
		
		
		
}
