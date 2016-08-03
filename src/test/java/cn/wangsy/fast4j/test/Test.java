package cn.wangsy.fast4j.test;

/** 
 * 说明：
 * @author wangsy
 * @date 创建时间：2016年8月3日 下午12:29:37
 */
public class Test {

	@org.junit.Test
	public void test(){
		try {
			Class forName = Class.forName("cn.wangsy.fast4j.web.quartz.FileScanJob");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
