package com.liyujian.utils;

import java.io.File;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import org.springframework.web.multipart.MultipartFile;  

//上传图片工具
public class UploadImg { 
	 public static void upload(MultipartFile filedata, String url, String newFileName){  
	    
	  if (filedata != null && !filedata.isEmpty()) { // 判断是否上传文件  
	     try {  
	      InputStream is = filedata.getInputStream();  
	      FileOutputStream fos = new FileOutputStream(new File(url,newFileName));  
	      byte[] buffer = new byte[8192]; // 每次读8K字节  
	      int count = 0;  
	      // 开始读取上传文件的字节，并将其输出到服务端的上传文件输出流中  
	      while ((count = is.read(buffer)) > 0) {  
	       fos.write(buffer, 0, count); // 向服务端文件写入字节流  
	      }  
	      fos.close(); // 关闭FileOutputStream对象  
	      is.close(); // InputStream对象  
	     } catch (FileNotFoundException e) {  
	    
	      e.printStackTrace();  
	     } catch (IOException e) {  
	      e.printStackTrace();  
	    
	     }  
	   }  
	  }  
}
