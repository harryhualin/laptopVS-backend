package com.mercury.laptapVS.bean;



import java.util.Date;

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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "MSI_COMMENT")
public class Comment {
	@Id
	@SequenceGenerator(name="msi_comment_seq_gen",sequenceName="msi_comment_seq",allocationSize=1)
	@GeneratedValue(generator="msi_comment_seq_gen",strategy=GenerationType.AUTO)
	private int id;
	
	
	@Column
	private int target_id;
	@Column
	private String content;
	@Column
	private Date comment_date;	
	
	@Transient
	private String username;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.DETACH)
	private Product product;
	

	
	

	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.DETACH)
	private User user;
	
	
	public Comment() {
		
	}


	public Comment(int id, int target_id, String content, Date comment_date, Product product, String username,
			User user) {
		super();
		this.id = id;
		this.target_id = target_id;
		this.content = content;
		this.comment_date = comment_date;
		this.product = product;
		this.username = username;
		this.user = user;
	}








	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	


	public Date getComment_date() {
		return comment_date;
	}


	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}


	public int getTarget_id() {
		return target_id;
	}





	public void setTarget_id(int target_id) {
		this.target_id = target_id;
	}

	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}




	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}



	@Override
	public String toString() {
		return "Comment [id=" + id + ", target_id=" + target_id + ", content=" + content + ", comment_date="
				+ comment_date + ", product=" + product + ", username=" + username + ", user=" + user + "]";
	}
	
	




}
