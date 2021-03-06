package com.hzh.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hzh.o2o.BaseTest;
import com.hzh.o2o.dto.ImageHolder;
import com.hzh.o2o.dto.ShopExecution;
import com.hzh.o2o.entity.Area;
import com.hzh.o2o.entity.PersonInfo;
import com.hzh.o2o.entity.Shop;
import com.hzh.o2o.entity.ShopCategory;
import com.hzh.o2o.enums.ShopStateEnum;
import com.hzh.o2o.exceptions.ShopOperationException;

public class ShopServiceTest extends BaseTest {
	
	@Autowired
	private ShopService shopService;
	
	
	@Test
	public void testGetShopList() {
		Shop shopCondition = new Shop();
		ShopCategory sc = new ShopCategory();
		sc.setShopCategoryId(33L);
		shopCondition.setShopCategory(sc);
		ShopExecution se = shopService.getShopList(shopCondition, 3, 2);
		System.out.println("店铺列表数为：" + se.getShopList().size());
		System.out.println("店铺总数为：" + se.getCount());
	}
	
	@Test
	@Ignore
	public void testAddShop() throws FileNotFoundException{
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		owner.setUserId(1L);
		area.setAreaId(2);
		shopCategory.setShopCategoryId(33L);
		
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("测试的店铺2");
		shop.setShopDesc("test2");
		shop.setShopAddr("test2");
		shop.setPhone("test2");
		shop.setShopImg("tes2");
		shop.setCreateTime(new Date());
		shop.setEnableStatus(0);
		shop.setAdvice("审核中");
		File shopImg = new File("C:/Users/mi/Pictures/Saved Pictures/kaix.jpg");
		InputStream is=new FileInputStream(shopImg);
		ImageHolder imageHolder = new ImageHolder(shopImg.getName(), is);
		ShopExecution se = shopService.addShop(shop, imageHolder );
		assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
	}
	
	@Test
	public void testModifyShop() throws ShopOperationException, FileNotFoundException {
		Shop shop = new Shop();
		shop.setShopId(40L);
		shop.setShopName("修改后的店铺名称");
		File shopImg = new File("C:/Users/mi/Pictures/Saved Pictures/bkaix.jpg");
		InputStream is = new FileInputStream(shopImg);
		ImageHolder imageHolder = new ImageHolder("bkaix.jpg", is);
		ShopExecution shopExecution = shopService.modifyShop(shop, imageHolder);
		System.out.println("新的图片地址为：" + shopExecution.getShop().getShopImg());
	}

}
