package cn.wangsy.fast4j.util;

import java.io.File;

/** 
 * @author wangsy
 * @date 创建时间：2016年7月24日 上午12:04:30
 * @version 1.0
 */
public class FileUtils {

	/***
	 * 根据路径删除文件
	 * @param path
	 * @return
	 */
	public static boolean deleteFile(String path){
		return deleteFile(new File(path));
	}
	
	public static boolean deleteFile(File file){
		if(file.exists() && file.isFile()){
			return file.delete();
		}
		return false;
	}
	
	public static boolean deleteDirectory(String path){
		return deleteDirectory(new File(path));
	}
	
	public static boolean deleteDirectory(File file){
		
		return true;
	}
	
	public static void copy(String source,String target){
		
	}
	
	
}
