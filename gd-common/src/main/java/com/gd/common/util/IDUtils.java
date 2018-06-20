package com.gd.common.util;

import java.util.Random;

public class IDUtils {
	
	//生成图片名
	public static String getImageName(){
		//取当前时间的长整
		long millis = System.currentTimeMillis();
		System.out.println(millis);
		Random random=new Random();
		int num3=random.nextInt(999);
		//如果不足三位的话，前面补0
		String str=millis+String.format("%03d", num3);
		return str;
	}
	
	//生成商品ID
	public static long getItemId(){
		long millis=System.currentTimeMillis();
		Random random=new Random();
		int num2=random.nextInt(99);
		String str=millis+String.format("%02d", num2);
		long id=new Long(str);
		return id;
	}
}
