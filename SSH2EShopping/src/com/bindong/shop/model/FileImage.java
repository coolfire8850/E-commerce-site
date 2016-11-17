package com.bindong.shop.model;

import java.io.File;

public class FileImage {
	
	//file并不是指前端jsp上传过来的文件本身，而是文件上传过来存放在临时文件夹下面的文件
	private File file;
	 //提交过来的file的MIME类型
	private String contentType;
	//提交过来的file的名字
	private String fileName;
	
	public File getFile() {
		return file;
	}
	//set方法可以不用和属性名一样，但是前台传进来时的参数得和set方法名相同。即前台传的参数为fileImage.upload  
	public void setUpload(File file) {
		
		this.file = file;
	}
	public String getContentType() {
		return contentType;
	}
	//相应的set名字前要加Upload
	public void setUploadContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setUploadFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	
	
	
	
	
}
