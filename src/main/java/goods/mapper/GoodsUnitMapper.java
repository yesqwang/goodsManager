package goods.mapper;

import goods.pojo.GoodsUnit;
import goods.pojo.GoodsUnitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsUnitMapper {
    long countByExample(GoodsUnitExample example);

    int deleteByExample(GoodsUnitExample example);

    int deleteByPrimaryKey(Integer unid);

    int insert(GoodsUnit record);

    int insertSelective(GoodsUnit record);

    List<GoodsUnit> selectByExample(GoodsUnitExample example);

    GoodsUnit selectByPrimaryKey(Integer unid);

    int updateByExampleSelective(@Param("record") GoodsUnit record, @Param("example") GoodsUnitExample example);

    int updateByExample(@Param("record") GoodsUnit record, @Param("example") GoodsUnitExample example);

    int updateByPrimaryKeySelective(GoodsUnit record);

    int updateByPrimaryKey(GoodsUnit record);
}