package io.mine.ft.train.service.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import io.mine.ft.train.dao.bean.product.ProductBasePO;
import io.mine.ft.train.service.biz.ShopBaseBiz;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AsyncShopBiz {
	
	@Autowired
	private ShopBaseBiz shopBiz;
	
	@Async
	public ProductBasePO getShopBase (Long id) {
		ProductBasePO productBasePO = shopBiz.getShopBase(id);
		
		log.info("@Async 异步查询商品详情：--{}", productBasePO);
		return productBasePO;
	}

}
