package com.hzh.o2o.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hzh.o2o.dao.AreaDao;
import com.hzh.o2o.entity.Area;
import com.hzh.o2o.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {
	
	@Autowired
	private AreaDao areaDao;

	@Override
	@Transactional
	public List<Area> getAreaList() {
		return areaDao.queryArea();
	}


}
