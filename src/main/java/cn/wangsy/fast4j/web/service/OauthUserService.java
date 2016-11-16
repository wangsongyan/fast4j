/**
 * 
 */
package cn.wangsy.fast4j.web.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cn.wangsy.fast4j.util.AppUtil;
import cn.wangsy.fast4j.web.model.dao.gen.OAuthUserMapper;
import cn.wangsy.fast4j.web.model.entity.OAuthUserAO;
import cn.wangsy.fast4j.web.model.entity.gen.OAuthUser;
import cn.wangsy.fast4j.web.model.entity.gen.OAuthUserExample;

/**
 * @author wangsy
 * @date 2016年11月15日下午4:21:37
 */
@Service
public class OauthUserService {

	@Resource
	private OAuthUserMapper oAuthUserMapper;
	
	public OAuthUser findByOAuthTypeAndOAuthId(String oAuthType,
			String oAuthId) {
		OAuthUserExample example = new OAuthUserExample();
		example.createCriteria().andOAuthIdEqualTo(oAuthId).andOAuthTypeEqualTo(oAuthType);
		List<OAuthUser> list = oAuthUserMapper.selectByExample(example);
		if(!CollectionUtils.isEmpty(list)){
			return list.get(0);
		}
		return null;
	}

	public OAuthUser save(OAuthUserAO oAuthInfo) {
		if(null == oAuthInfo){
			return null;
		}
		if(StringUtils.isBlank(oAuthInfo.getId())){
			oAuthInfo.setId(AppUtil.getUUID());
			oAuthUserMapper.insertSelective(oAuthInfo);
		}else{
			oAuthUserMapper.updateByPrimaryKeySelective(oAuthInfo);
		}
		return oAuthInfo;
	}

}
