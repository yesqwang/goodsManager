package goods.mapper;

import goods.pojo.ApplyBuylist;
import goods.pojo.ApplyBuylistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplyBuylistMapper {
    long countByExample(ApplyBuylistExample example);

    int deleteByExample(ApplyBuylistExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ApplyBuylist record);

    int insertSelective(ApplyBuylist record);

    List<ApplyBuylist> selectByExample(ApplyBuylistExample example);

    ApplyBuylist selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ApplyBuylist record, @Param("example") ApplyBuylistExample example);

    int updateByExample(@Param("record") ApplyBuylist record, @Param("example") ApplyBuylistExample example);

    int updateByPrimaryKeySelective(ApplyBuylist record);

    int updateByPrimaryKey(ApplyBuylist record);
}