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

//文件上传工具类具体实现
@Component("fileUpload") //在baseAction中进行@Resource注解
public class FileUploadUtil implements FileUpload {
	
	/*value 表示去beans.xml文件中找id="prop"的bean,它是通过注解的方式读取public.properties配置文件，
	  然后去相应的配置文件读取key=filePath的值
	  */
	@Value("#{prop.filePath}")
	private String filePath;
	@Value("#{prop.basePath+prop.bankImagePath}")
	private String bankImagePath;
	
	
	
/*	public void setFilePath(String filePath) {
		System.out.println("上传文件保存路径为:"+filePath);
		this.filePath = filePath;
	}*/
	
	//1.通过文件名获取扩展名
	private String getFileExt(String filename){
		
		return FilenameUtils.getExtension(filename);
	}
	
	//2.生成uuid随机数，作为新的文件名
	private String newFileName(String fileName){
		String ext = getFileExt(fileName);
		
		return UUID.randomUUID().toString()+"."+ext;
		
	}
	
	//实现文件上传的功能，返回上传后新的文件名称
	@Override
	public String uploadFile(FileImage fileImage) {
		//获取新的唯一文件名称
		String realpath = ServletActionContext.getRequest().getRealPath("/files");
		String pic = newFileName(fileImage.getFileName());
		System.out.println("pic名称为"+pic);
		System.out.println("源文件名称为："+fileImage.getFileName());
		System.out.println("保存路径为："+filePath);
		try {
			//第一参数是上传的文件，第二个参数是将文件拷贝到新路径下
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
		//获取路径中所有文件名,同时进行过滤
		String[] list = new File(bankImagePath).list(new FilenameFilter() {
			
			//测试指定文件是否应该包含在某一文件列表中
			@Override
			public boolean accept(File dir, String name) {
				
				System.out.println("dir:" + dir + ",name:" + name);		
				//通过后缀名来实现文件的过滤效果,返回真就放到list中，返回假就过滤掉
				return name.endsWith(".gif");
			}
		});
		
		return list;
	}

}
