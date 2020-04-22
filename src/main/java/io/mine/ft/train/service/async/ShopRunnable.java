package io.mine.ft.train.service.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import io.mine.ft.train.dao.bean.product.ProductBasePO;
import io.mine.ft.train.service.biz.ShopBaseBiz;
import lombok.extern.slf4j.Slf4j;


@Component("shopRunnable")
@Scope(value = "prototype")
@Slf4j
public class ShopRunnable implements Runnable {
	
	@Autowired
	private ShopBaseBiz shopBiz;
	
	private Long shopId;
	
	private ShopRunnable(Long shopId) {
		this.shopId = shopId;
	}

	@Override
	public void run() {
		ProductBasePO productBasePO = shopBiz.getShopBase(shopId);
		log.info("异步线程查询ShopRunnable_1 --{}", productBasePO);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		
		}
		ProductBasePO productBasePO2 = shopBiz.getShopBase(shopId);
		log.info("异步线程查询 ShopRunnable_2 --{}", productBasePO2);
	}
}
