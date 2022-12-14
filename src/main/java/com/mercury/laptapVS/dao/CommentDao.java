package com.mercury.laptapVS.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.laptapVS.bean.Comment;


public interface CommentDao extends JpaRepository<Comment,Integer>{
	public List<Comment> findAllByProductId(int productId);
}
