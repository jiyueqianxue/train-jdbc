package io.mine.ft.train.dao.mapper.product;

import io.mine.ft.train.dao.bean.product.ProductBasePO;
import io.mine.ft.train.dao.bean.product.ProductBasePOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductBasePOMapper {
    int countByExample(ProductBasePOExample example);

    int deleteByExample(ProductBasePOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductBasePO record);

    int insertSelective(ProductBasePO record);

    int insertBatch(@Param("records") List<ProductBasePO> records);

    List<ProductBasePO> selectByExample(ProductBasePOExample example);

    ProductBasePO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProductBasePO record, @Param("example") ProductBasePOExample example);

    int updateByExample(@Param("record") ProductBasePO record, @Param("example") ProductBasePOExample example);

    int updateByPrimaryKeySelective(ProductBasePO record);

    int updateByPrimaryKey(ProductBasePO record);
}