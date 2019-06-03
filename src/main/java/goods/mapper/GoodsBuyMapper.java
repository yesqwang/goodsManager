package goods.mapper;

import goods.pojo.GoodsBuy;
import goods.pojo.GoodsBuyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsBuyMapper {
    long countByExample(GoodsBuyExample example);

    int deleteByExample(GoodsBuyExample example);

    int deleteByPrimaryKey(Integer gbid);

    int insert(GoodsBuy record);

    int insertSelective(GoodsBuy record);

    List<GoodsBuy> selectByExample(GoodsBuyExample example);

    GoodsBuy selectByPrimaryKey(Integer gbid);

    int updateByExampleSelective(@Param("record") GoodsBuy record, @Param("example") GoodsBuyExample example);

    int updateByExample(@Param("record") GoodsBuy record, @Param("example") GoodsBuyExample example);

    int updateByPrimaryKeySelective(GoodsBuy record);

    int updateByPrimaryKey(GoodsBuy record);
}