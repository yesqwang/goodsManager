package goods.mapper;

import goods.pojo.GoodsStore;
import goods.pojo.GoodsStoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsStoreMapper {
    long countByExample(GoodsStoreExample example);

    int deleteByExample(GoodsStoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsStore record);

    int insertSelective(GoodsStore record);

    List<GoodsStore> selectByExample(GoodsStoreExample example);

    GoodsStore selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsStore record, @Param("example") GoodsStoreExample example);

    int updateByExample(@Param("record") GoodsStore record, @Param("example") GoodsStoreExample example);

    int updateByPrimaryKeySelective(GoodsStore record);

    int updateByPrimaryKey(GoodsStore record);
}