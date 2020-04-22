package io.mine.ft.train.dao.mapper.product;

import io.mine.ft.train.dao.bean.product.ProductFilePO;
import io.mine.ft.train.dao.bean.product.ProductFilePOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductFilePOMapper {
    int countByExample(ProductFilePOExample example);

    int deleteByExample(ProductFilePOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductFilePO record);

    int insertSelective(ProductFilePO record);

    int insertBatch(@Param("records") List<ProductFilePO> records);

    List<ProductFilePO> selectByExample(ProductFilePOExample example);

    ProductFilePO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProductFilePO record, @Param("example") ProductFilePOExample example);

    int updateByExample(@Param("record") ProductFilePO record, @Param("example") ProductFilePOExample example);

    int updateByPrimaryKeySelective(ProductFilePO record);

    int updateByPrimaryKey(ProductFilePO record);
}