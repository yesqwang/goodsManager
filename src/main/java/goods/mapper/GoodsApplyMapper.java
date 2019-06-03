package goods.mapper;

import goods.pojo.GoodsApply;
import goods.pojo.GoodsApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsApplyMapper {
    long countByExample(GoodsApplyExample example);

    int deleteByExample(GoodsApplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsApply record);

    int insertSelective(GoodsApply record);

    List<GoodsApply> selectByExample(GoodsApplyExample example);

    GoodsApply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsApply record, @Param("example") GoodsApplyExample example);

    int updateByExample(@Param("record") GoodsApply record, @Param("example") GoodsApplyExample example);

    int updateByPrimaryKeySelective(GoodsApply record);

    int updateByPrimaryKey(GoodsApply record);
}