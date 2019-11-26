package com.hzh.o2o.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hzh.o2o.BaseTest;
import com.hzh.o2o.entity.ShopCategory;

public class ShopCategoryDaoTest extends BaseTest {
	
	@Autowired
	private ShopCategoryDao shopCategoryDao;
	
	@Test
	@Ignore
	public void testQueryShopCategory() {
		List<ShopCategory> shopCategoryList = shopCategoryDao.queryShopCategory(null);
		System.out.println(shopCategoryList.get(0).getShopCategoryName());
		
	}

}
