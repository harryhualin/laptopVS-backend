package com.mercury.laptapVS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.laptapVS.bean.Comment;
import com.mercury.laptapVS.dao.CommentDao;


@Service
public class CommentService {
	@Autowired
	private CommentDao commentDao;
	

	public List<Comment> getComments(int productId) {
		List<Comment>list= commentDao.findAllByProductId(productId);
				list.forEach((comment)->{
					comment.setUsername(comment.getUser().getUsername());
					comment.setUser(null);
					comment.setProduct(null);
				});
		
		return list;
	}


	public Comment save(Comment comment) {
		Comment savedComment=commentDao.save(comment);
		savedComment.setUsername(savedComment.getUser().getUsername());
		savedComment.setUser(null);
		savedComment.setProduct(null);
		return savedComment;
	}


	public Comment getCommentById(int id) {
		Comment savedComment=commentDao.findById(id).get();
		savedComment.setUsername(savedComment.getUser().getUsername());
		savedComment.setUser(null);
		savedComment.setProduct(null);
		return savedComment;
	}
	
	

}
