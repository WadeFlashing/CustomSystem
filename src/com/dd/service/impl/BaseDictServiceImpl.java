package com.dd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dd.dao.BaseDictDao;
import com.dd.po.BaseDict;
import com.dd.service.BaseDictService;

@Service("baseDictService")
public class BaseDictServiceImpl implements BaseDictService{

	@Autowired
	private BaseDictDao baseDictDao;
	public List<BaseDict> findBaseDictByTypeCode(String typecode){
		return baseDictDao.selectBaseDictByTypeCode(typecode);
	}
	
}
