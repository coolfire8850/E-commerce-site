package com.bindong.shop.utils;

import com.bindong.shop.model.FileImage;

//文件上传工具类接口
public interface FileUpload {
	
	//实现上传文件的功能，返回上传后新的文件名称
	public abstract String uploadFile(FileImage fileImage);
	//获得银行的图标
	public String[] getBankImage();
}
