package com.hzh.o2o.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hzh.o2o.BaseTest;
import com.hzh.o2o.entity.Area;

public class AreaServiceTest  extends BaseTest{
	
	@Autowired
	private AreaService areaService;
	
	@Test
	@Ignore
	public void testGetAreaList() {
		List<Area> areaList = areaService.getAreaList();
		assertEquals("西苑", areaList.get(0).getAreaName());
		System.out.println("cc");
	}
 
}
