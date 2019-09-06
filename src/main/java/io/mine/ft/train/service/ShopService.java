package io.mine.ft.train.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.mine.ft.train.biz.ShopBiz;
import io.mine.ft.train.biz.async.AsyncShopBiz;
import io.mine.ft.train.biz.async.ShopExecutor;
import io.mine.ft.train.biz.async.ShopRunnable;
import io.mine.ft.train.common.utils.SpringContextUtil;
import io.mine.ft.train.dao.bean.audit.ProductBasePO;

@Service
public class ShopService {
	
	@Autowired
	private ShopExecutor shopExecutor;
	
	@Autowired
	private ShopBiz shopBiz;
	
	@Autowired
	private AsyncShopBiz asyncShopBiz;
	
	@Transactional
	public void executorShop() throws Exception {
		
		Long shopId = 1L;
		shopBiz.updateShopStatus(shopId, (byte)1);
		insertShopOrder(shopId);
		Runnable reunnable = (ShopRunnable)SpringContextUtil.getApplicationContext().getBean("shopRunnable", shopId);
		shopExecutor.execute(reunnable);
		Thread.sleep(1000);
	}
	
	public void insertShopOrder(Long shopId) throws Exception {
		ProductBasePO shopBase = shopBiz.getShopBase(shopId);
		if (shopBase.getProductStatus() ==  1) {
			shopBiz.insertShopOrder(shopBase.getProductStatus());
		}
		
	}
	@Transactional
	public void executorShop2() throws Exception {
		
		Long shopId = 1L;
		shopBiz.updateShopStatus(shopId, (byte)3);
		asyncShopBiz.getShopBase(shopId);
		Thread.sleep(1000);
	}
	
	@Transactional
	public void executorShop3() throws Exception {
		
		Long shopId = 1L;
		asyncShopBiz.getShopBase(shopId);
		Thread.sleep(1000);
	}
}
