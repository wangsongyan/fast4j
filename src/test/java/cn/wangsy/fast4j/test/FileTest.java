package cn.wangsy.fast4j.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

/** 
 * 说明：
 * @author wangsy
 * @date 创建时间：2016年8月1日 下午1:44:09
 */
public class FileTest {

	@Test
	public void test() throws IOException{
		System.out.println("test");
		
		//FileUtils fileUtils = 
		//File file = new File("D:/asd");
		//FileUtils.forceMkdir(file);
		//FileUtils.forceDelete(file);
		
		//FileUtils.copyDirectory(new File("D:/dx-workspace"), file);
		
		
		InputStream in = new URL( "http://www.blogjava.net/ashutc/archive/2010/07/13/325933.html" ).openStream();
		 try {
		   System.out.println( IOUtils.toString( in ) );
		 } finally {
		   IOUtils.closeQuietly(in);
		 }
		
	}
	
	
	
}
