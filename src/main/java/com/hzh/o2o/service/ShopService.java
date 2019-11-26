package com.hzh.o2o.service;

import java.io.File;
import java.io.InputStream;

import com.hzh.o2o.dto.ImageHolder;
import com.hzh.o2o.dto.ShopExecution;
import com.hzh.o2o.entity.Shop;
import com.hzh.o2o.exceptions.ShopOperationException;

public interface ShopService {
	
	
	
	/**
	 * 根据shopCondition分页查询相应店铺列表
	 * 
	 * @param shopCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);
	
	
	/**
	 * 更新店铺信息，包括对图片的处理
	 * 
	 * @param shop
	 * @param shopImg
	 * @return
	 * @throws ShopOperationException
	 */
	ShopExecution modifyShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;
	
	
	

	/**
	 * 通过店铺Id获取店铺信息
	 * 
	 * @param shopId
	 * @return
	 */
	Shop getByShopId(long shopId);
	
	
	/**
	 * 注册店铺信息，包括图片处理
	 * 
	 * @param shop
	 * @param shopImgInputStream
	 * @param fileName
	 * @return
	 * @throws ShopOperationException
	 */
	ShopExecution addShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;
}
