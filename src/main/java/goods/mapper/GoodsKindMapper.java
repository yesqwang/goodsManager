package goods.mapper;

import goods.pojo.GoodsKind;
import goods.pojo.GoodsKindExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsKindMapper {
    long countByExample(GoodsKindExample example);

    int deleteByExample(GoodsKindExample example);

    int deleteByPrimaryKey(Integer kid);

    int insert(GoodsKind record);

    int insertSelective(GoodsKind record);

    List<GoodsKind> selectByExample(GoodsKindExample example);

    GoodsKind selectByPrimaryKey(Integer kid);

    int updateByExampleSelective(@Param("record") GoodsKind record, @Param("example") GoodsKindExample example);

    int updateByExample(@Param("record") GoodsKind record, @Param("example") GoodsKindExample example);

    int updateByPrimaryKeySelective(GoodsKind record);

    int updateByPrimaryKey(GoodsKind record);
}