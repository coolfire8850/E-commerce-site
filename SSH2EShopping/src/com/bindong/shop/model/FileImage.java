package com.bindong.shop.model;

import java.io.File;

public class FileImage {
	
	//file������ָǰ��jsp�ϴ��������ļ����������ļ��ϴ������������ʱ�ļ���������ļ�
	private File file;
	 //�ύ������file��MIME����
	private String contentType;
	//�ύ������file������
	private String fileName;
	
	public File getFile() {
		return file;
	}
	//set�������Բ��ú�������һ��������ǰ̨������ʱ�Ĳ����ú�set��������ͬ����ǰ̨���Ĳ���ΪfileImage.upload  
	public void setUpload(File file) {
		
		this.file = file;
	}
	public String getContentType() {
		return contentType;
	}
	//��Ӧ��set����ǰҪ��Upload
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
