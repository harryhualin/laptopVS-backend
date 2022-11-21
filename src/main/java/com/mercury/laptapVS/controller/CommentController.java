package com.mercury.laptapVS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.laptapVS.bean.Comment;
import com.mercury.laptapVS.http.DataResponse;
import com.mercury.laptapVS.service.CommentService;


@RestController
@RequestMapping("/comments")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/{productId}")
	public DataResponse<Comment> getAll(@PathVariable int productId){
		return new DataResponse<Comment>(true,200,"get comments",commentService.getComments(productId));
	}
	
	@PostMapping
	public DataResponse<Comment> save(@RequestBody Comment comment)
	{	
		return new DataResponse<Comment>(true,200,"post a new comment",commentService.save(comment));
	}
}
