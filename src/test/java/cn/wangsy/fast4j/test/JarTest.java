package cn.wangsy.fast4j.test;

/*import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.jar.JarFile;

import org.junit.Test;

import com.baomidou.framework.common.JarHelper;

*//** 
 * 说明：
 * @author wangsy
 * @date 创建时间：2016年8月1日 下午2:04:59
 *//*
public class JarTest {

	@Test
	public void jar() throws IOException{
		
		JarFile jarFile = new JarFile(new File("D:/dx-workspace/workspace1/fast4j/src/main/webapp/WEB-INF/lib/shiro-freemarker-tags-0.1-SNAPSHOT.jar"));
		List<String> pathList=JarHelper.listFiles(jarFile, ".class");
		for(String str:pathList){
			//System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&7"+str);
			
			List<String> contents = JarHelper.readLines(jarFile, str);
//			for(String c:contents){
//				System.out.println(c);
//			}
			System.out.println(str+"["+contents.size()+"]");
		}
		
	}
	
}
*/