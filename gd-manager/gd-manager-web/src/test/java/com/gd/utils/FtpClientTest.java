package com.gd.utils;
import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;
public class FtpClientTest {
	
	@Test
	public void FtpCli() throws Exception{
		//创建ftp对象
		FTPClient ftpClient = new FTPClient();
		//创建连接
		ftpClient.connect("192.168.253.11");
		//登录
		ftpClient.login("ftpuser", "ftpuser");
		//创建输入流
		FileInputStream inputStream=new FileInputStream(new File("E:\\picture\\1.png"));
		//设置ftp上传类型
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		//设置文件名
		ftpClient.storeFile("123.jpg", inputStream);
		//关闭资源
		inputStream.close();
		ftpClient.logout();
	}
}
