package io.mine.ft.train.service.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mine.ft.train.common.exception.BusinessException;
import io.mine.ft.train.dao.bean.product.ProductBasePO;
import io.mine.ft.train.dao.mapper.product.ProductBasePOMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ShopBaseBiz {
	
	@Autowired
	private ProductBasePOMapper productBasePOMapper;
	
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
	public void updateShopTitle(Long id, String title) throws BusinessException{
		
		ProductBasePO record = new ProductBasePO();
		record.setId(id);
		record.setTitle(title);
		int num = productBasePOMapper.updateByPrimaryKeySelective(record);
		if (num == 1) {
			// throw new RuntimeException();
			// throw new BusinessException(ResultCodeEnum.PARAMS_INAVAILABLE);
		}
		log.info("更新商品title：--{}", num);
	}
	
	public void insertShopTitle(String title, String productDesc) throws BusinessException{
		
		ProductBasePO record = new ProductBasePO();
		record.setTitle(title);
		record.setProductDesc(productDesc);
		record.setBizLogo("/1/2");
		record.setServiceType("");
		int num = productBasePOMapper.insertSelective(record);
		if (num == 1) {
			// throw new RuntimeException();
			// throw new BusinessException(ResultCodeEnum.PARAMS_INAVAILABLE);
		}
		log.info("插入商品title：--{}", num);
	}
	
}
