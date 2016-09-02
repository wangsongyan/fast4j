package cn.wangsy.fast4j.test;

import org.junit.Test;
import org.scribe.builder.api.DefaultApi20;

import cn.wangsy.fast4j.core.oauth2.GithubApi;

/** 
 * 说明：
 * @author wangsy
 * @date 创建时间：2016年9月2日 下午12:39:09
 */
public class OAuth2Test {

	@Test
	public void test(){
		DefaultApi20 api = new GithubApi("123");
		System.out.println(api.getAccessTokenEndpoint());
	}
	
}
