package com.bindong.shop.utils.impl;

import java.io.File;
import java.io.FilenameFilter;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.bindong.shop.model.FileImage;
import com.bindong.shop.utils.FileUpload;

//�ļ��ϴ����������ʵ��
@Component("fileUpload") //��baseAction�н���@Resourceע��
public class FileUploadUtil implements FileUpload {
	
	/*value ��ʾȥbeans.xml�ļ�����id="prop"��bean,����ͨ��ע��ķ�ʽ��ȡpublic.properties�����ļ���
	  Ȼ��ȥ��Ӧ�������ļ���ȡkey=filePath��ֵ
	  */
	@Value("#{prop.filePath}")
	private String filePath;
	@Value("#{prop.basePath+prop.bankImagePath}")
	private String bankImagePath;
	
	
	
/*	public void setFilePath(String filePath) {
		System.out.println("�ϴ��ļ�����·��Ϊ:"+filePath);
		this.filePath = filePath;
	}*/
	
	//1.ͨ���ļ�����ȡ��չ��
	private String getFileExt(String filename){
		
		return FilenameUtils.getExtension(filename);
	}
	
	//2.����uuid���������Ϊ�µ��ļ���
	private String newFileName(String fileName){
		String ext = getFileExt(fileName);
		
		return UUID.randomUUID().toString()+"."+ext;
		
	}
	
	//ʵ���ļ��ϴ��Ĺ��ܣ������ϴ����µ��ļ�����
	@Override
	public String uploadFile(FileImage fileImage) {
		//��ȡ�µ�Ψһ�ļ�����
		String realpath = ServletActionContext.getRequest().getRealPath("/files");
		String pic = newFileName(fileImage.getFileName());
		System.out.println("pic����Ϊ"+pic);
		System.out.println("Դ�ļ�����Ϊ��"+fileImage.getFileName());
		System.out.println("����·��Ϊ��"+filePath);
		try {
			//��һ�������ϴ����ļ����ڶ��������ǽ��ļ���������·����
			FileUtil.copyFile(fileImage.getFile(), new File(filePath,pic));
			return pic;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}finally{
			
			//fileImage.getFile().delete();
		}
	}
	
	public String[] getBankImage(){
		//��ȡ·���������ļ���,ͬʱ���й���
		String[] list = new File(bankImagePath).list(new FilenameFilter() {
			
			//����ָ���ļ��Ƿ�Ӧ�ð�����ĳһ�ļ��б���
			@Override
			public boolean accept(File dir, String name) {
				
				System.out.println("dir:" + dir + ",name:" + name);		
				//ͨ����׺����ʵ���ļ��Ĺ���Ч��,������ͷŵ�list�У����ؼپ͹��˵�
				return name.endsWith(".gif");
			}
		});
		
		return list;
	}

}
