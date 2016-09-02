package cn.wangsy.fast4j.test;

import com.alibaba.fastjson.JSON;

import cn.wangsy.fast4j.util.ReflectionUtils;

/** 
 * 说明：
 * @author wangsy
 * @date 创建时间：2016年9月2日 上午11:13:21
 */
public class ReflectionTest {

	public static void main(String[] args){
		
		Bill bill = new Bill();
		ReflectionUtils.setFieldValue(bill, "summary", "haha");
		System.out.println(JSON.toJSON(bill));
	}
	
}
