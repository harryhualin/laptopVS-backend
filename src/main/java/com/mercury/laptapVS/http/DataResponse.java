package com.mercury.laptapVS.http;

import java.util.ArrayList;
import java.util.List;

public class DataResponse <T> extends Response{
	private List<T> dataList;

	public DataResponse() {
		super();
		this.dataList=null;
	}

	public DataResponse(boolean success, int code, String message) {
		super(success, code, message);
		this.dataList=null;
	}

	public DataResponse(boolean success, String message) {
		super(success, message);
		this.dataList=null;
	}

	public DataResponse(boolean success) {
		super(success);
		this.dataList=null;
	}

	public DataResponse(boolean success, int code, String message,List<T> dataList) {
		super(success, code, message);
		this.dataList=dataList;
	}
	public DataResponse(boolean success, int code, String message,T data) {
		super(success, code, message);
		List<T> dataList=new ArrayList<T>();
		dataList.add(data);
		this.dataList=dataList;
	}
	
	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	
	
	
}
