package io.mine.ft.train.dao.mapper.audit;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import io.mine.ft.train.dao.bean.audit.ProductOrderPO;
import io.mine.ft.train.dao.bean.audit.ProductOrderPOExample;

public interface ProductOrderPOMapper {
    int countByExample(ProductOrderPOExample example);

    int deleteByExample(ProductOrderPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductOrderPO record);

    int insertSelective(ProductOrderPO record);

    int insertBatch(@Param("records") List<ProductOrderPO> records);

    List<ProductOrderPO> selectByExample(ProductOrderPOExample example);

    ProductOrderPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProductOrderPO record, @Param("example") ProductOrderPOExample example);

    int updateByExample(@Param("record") ProductOrderPO record, @Param("example") ProductOrderPOExample example);

    int updateByPrimaryKeySelective(ProductOrderPO record);

    int updateByPrimaryKey(ProductOrderPO record);
}