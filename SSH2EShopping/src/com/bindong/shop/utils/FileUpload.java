package com.bindong.shop.utils;

import com.bindong.shop.model.FileImage;

//�ļ��ϴ�������ӿ�
public interface FileUpload {
	
	//ʵ���ϴ��ļ��Ĺ��ܣ������ϴ����µ��ļ�����
	public abstract String uploadFile(FileImage fileImage);
	//������е�ͼ��
	public String[] getBankImage();
}
