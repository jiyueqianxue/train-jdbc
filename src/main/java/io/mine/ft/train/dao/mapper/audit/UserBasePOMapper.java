package io.mine.ft.train.dao.mapper.audit;

import io.mine.ft.train.dao.bean.audit.UserBasePO;
import io.mine.ft.train.dao.bean.audit.UserBasePOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserBasePOMapper {
    int countByExample(UserBasePOExample example);

    int deleteByExample(UserBasePOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserBasePO record);

    int insertSelective(UserBasePO record);

    int insertBatch(@Param("records") List<UserBasePO> records);

    List<UserBasePO> selectByExample(UserBasePOExample example);

    UserBasePO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserBasePO record, @Param("example") UserBasePOExample example);

    int updateByExample(@Param("record") UserBasePO record, @Param("example") UserBasePOExample example);

    int updateByPrimaryKeySelective(UserBasePO record);

    int updateByPrimaryKey(UserBasePO record);
}