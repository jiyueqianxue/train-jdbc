package io.mine.ft.train.biz;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mine.ft.train.common.exception.BusinessException;
import io.mine.ft.train.common.utils.DateFormatUtil;
import io.mine.ft.train.dao.bean.audit.ProductBasePO;
import io.mine.ft.train.dao.bean.audit.ProductOrderPO;
import io.mine.ft.train.dao.mapper.audit.ProductBasePOMapper;
import io.mine.ft.train.dao.mapper.audit.ProductOrderPOMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ShopBiz {
	
	@Autowired
	private ProductBasePOMapper productBasePOMapper;
	
	@Autowired
	private ProductOrderPOMapper productOrderPOMapper;
	
	public ProductBasePO getShopBase(Long id){
		ProductBasePO productBasePO = productBasePOMapper.selectByPrimaryKey(id);
		//log.info("查询商品详情：--{}", productBasePO);
		return productBasePO;
	}
	/**
	 * Spring使用声明式事务处理，默认情况下，如果被注解的数据库操作方法中发生了unchecked异常，
	 *     所有的数据库操作将rollback；如果发生的异常是checked异常，默认情况下数据库操作还是会提交的。
	 * @param id     rollbackFor=Exception.class
	 * @param status
	 * @throws BusinessException
	 */
	
	public void updateShopStatus(Long id, Byte status) throws BusinessException{
		
		ProductBasePO record = new ProductBasePO();
		record.setId(id);
		record.setProductStatus(status);
		record.setMobilePhone("776778");
		int num = productBasePOMapper.updateByPrimaryKeySelective(record);
		if (num == 1) {
			// throw new RuntimeException();
			// throw new BusinessException(ResultCodeEnum.PARAMS_INAVAILABLE);
		}
		log.info("更新商品详情：--{}", num);
	}
	
	public void insertShopOrder(Byte shopStatus) throws BusinessException{
		if (shopStatus == 1) {
			//throw new BusinessException(ResultCodeEnum.SYSTEM_INNER_ERROR);
		}
		ProductOrderPO record = new ProductOrderPO();
		record.setAmount(new BigDecimal("1000"));
		record.setOrderNo(DateFormatUtil.dateToDefaultTimeStr(new Date()));
		record.setOrderStatus((byte)1);
		record.setOrderType((byte)1);
		record.setProductId(2233L);
		record.setUserId(1243L);
		int num = productOrderPOMapper.insertSelective(record);
		if (num == 1) {
			throw new RuntimeException();
		}
		
		log.info("插入订单详情：--{}", num);
	}
}
