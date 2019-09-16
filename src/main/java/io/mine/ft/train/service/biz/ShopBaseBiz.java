package io.mine.ft.train.service.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mine.ft.train.common.exception.BusinessException;
import io.mine.ft.train.dao.bean.product.ProductBasePO;
import io.mine.ft.train.dao.mapper.product.ProductBasePOMapper;
import lombok.extern.slf4j.Slf4j;
/**
	TransactionDefinition.PROPAGATION_REQUIRED：如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。这是默认值。
	TransactionDefinition.PROPAGATION_REQUIRES_NEW：创建一个新的事务，如果当前存在事务，则把当前事务挂起。
	TransactionDefinition.PROPAGATION_SUPPORTS：如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行。
	TransactionDefinition.PROPAGATION_NOT_SUPPORTED：以非事务方式运行，如果当前存在事务，则把当前事务挂起。
	TransactionDefinition.PROPAGATION_NEVER：以非事务方式运行，如果当前存在事务，则抛出异常。
	TransactionDefinition.PROPAGATION_MANDATORY：如果当前存在事务，则加入该事务；如果当前没有事务，则抛出异常。
	TransactionDefinition.PROPAGATION_NESTED：如果当前存在事务，则创建一个事务作为当前事务的嵌套事务来运行；（子事务）
	如果当前没有事务，则该取值等价于TransactionDefinition.PROPAGATION_REQUIRED。

	value	String	可选的限定描述符，指定使用的事务管理器
	propagation	enum: Propagation	可选的事务传播行为设置
	isolation	enum: Isolation	可选的事务隔离级别设置
	readOnly	boolean	读写或只读事务，默认读写
	timeout	int (in seconds granularity)	事务超时时间设置
	rollbackFor	Class对象数组，必须继承自Throwable	导致事务回滚的异常类数组
	rollbackForClassName	类名数组，必须继承自Throwable	导致事务回滚的异常类名字数组
	noRollbackFor	Class对象数组，必须继承自Throwable	不会导致事务回滚的异常类数组
	noRollbackForClassName	类名数组，必须继承自Throwable	不会导致事务回滚的异常类名字数组
	[ Spring使用声明式事务处理，默认情况下，如果被注解的数据库操作方法中发生了unchecked异常(Error或者RuntimeException)，
	所有的数据库操作将rollback；如果发生的异常是checked异常(IOException)，默认情况下数据库操作还是会提交的。]
*
*/
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
	 * 
	 * @param id     rollbackFor=Exception.class
	 */
	//@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void updateShopTitle_1(Long id, String title) throws BusinessException{
		
		ProductBasePO record = new ProductBasePO();
		record.setId(id);
		record.setTitle(title);
		int num = productBasePOMapper.updateByPrimaryKeySelective(record);
		if (num == 1) {
			//throw new RuntimeException();
			//throw new BusinessException(ResultCodeEnum.PARAMS_INAVAILABLE);
		}
		log.info("更新商品title_1：--{}", num);
	}
	
	//@Transactional(readOnly = false, propagation = Propagation.NESTED)
	public void updateShopTitle_2(Long id, String title) throws BusinessException{
		
		ProductBasePO record = new ProductBasePO();
		record.setId(id);
		record.setTitle(title);
		int num = productBasePOMapper.updateByPrimaryKeySelective(record);
		if (num == 1) {
			throw new RuntimeException();
			// throw new BusinessException(ResultCodeEnum.PARAMS_INAVAILABLE);
		}
		log.info("更新商品title_2：--{}", num);
	}
	
	//@Transactional(readOnly = false, propagation = Propagation.NEVER)
	public void updateShopTitle_3(Long id, String title) throws BusinessException{
		
		ProductBasePO record = new ProductBasePO();
		record.setId(id);
		record.setTitle(title);
		int num = productBasePOMapper.updateByPrimaryKeySelective(record);
		if (num == 1) {
			// throw new RuntimeException();
			// throw new BusinessException(ResultCodeEnum.PARAMS_INAVAILABLE);
		}
		log.info("更新商品title_3：--{}", num);
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
