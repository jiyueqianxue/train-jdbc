package io.mine.ft.train.dao.mapper.product;

import io.mine.ft.train.dao.bean.product.ProductCategoryPO;
import io.mine.ft.train.dao.bean.product.ProductCategoryPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductCategoryPOMapper {
    int countByExample(ProductCategoryPOExample example);

    int deleteByExample(ProductCategoryPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductCategoryPO record);

    int insertSelective(ProductCategoryPO record);

    int insertBatch(@Param("records") List<ProductCategoryPO> records);

    List<ProductCategoryPO> selectByExample(ProductCategoryPOExample example);

    ProductCategoryPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProductCategoryPO record, @Param("example") ProductCategoryPOExample example);

    int updateByExample(@Param("record") ProductCategoryPO record, @Param("example") ProductCategoryPOExample example);

    int updateByPrimaryKeySelective(ProductCategoryPO record);

    int updateByPrimaryKey(ProductCategoryPO record);
}