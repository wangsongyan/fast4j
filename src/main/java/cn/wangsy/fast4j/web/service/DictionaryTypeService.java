package cn.wangsy.fast4j.web.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wangsy.fast4j.util.Pager;
import cn.wangsy.fast4j.web.model.dao.gen.DictionaryTypeMapper;
import cn.wangsy.fast4j.web.model.entity.gen.DictionaryType;
import cn.wangsy.fast4j.web.model.entity.gen.DictionaryTypeExample;

/** 
 * 说明：
 * @author wangsy
 * @date 创建时间：2016年9月8日 上午11:56:15
 */
@Service
public class DictionaryTypeService {

	@Resource
	private DictionaryTypeMapper dictionaryTypeMapper;
	
	public List<DictionaryType> list(Pager pager){
		DictionaryTypeExample example = new DictionaryTypeExample();
		example.setPager(pager);
		return dictionaryTypeMapper.selectByExample(example);
	}
	
}
