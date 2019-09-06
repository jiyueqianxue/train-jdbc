package io.mine.ft.train.dao.mapper.audit;

import io.mine.ft.train.dao.bean.audit.AuditInfoPO;
import io.mine.ft.train.dao.bean.audit.AuditInfoPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AuditInfoPOMapper {
    int countByExample(AuditInfoPOExample example);

    int deleteByExample(AuditInfoPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AuditInfoPO record);

    int insertSelective(AuditInfoPO record);

    int insertBatch(@Param("records") List<AuditInfoPO> records);

    List<AuditInfoPO> selectByExample(AuditInfoPOExample example);

    AuditInfoPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AuditInfoPO record, @Param("example") AuditInfoPOExample example);

    int updateByExample(@Param("record") AuditInfoPO record, @Param("example") AuditInfoPOExample example);

    int updateByPrimaryKeySelective(AuditInfoPO record);

    int updateByPrimaryKey(AuditInfoPO record);
}