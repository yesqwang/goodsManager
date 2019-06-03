package goods.mapper;

import goods.pojo.GoodsWhoApply;
import goods.pojo.GoodsWhoApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsWhoApplyMapper {
    long countByExample(GoodsWhoApplyExample example);

    int deleteByExample(GoodsWhoApplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsWhoApply record);

    int insertSelective(GoodsWhoApply record);

    List<GoodsWhoApply> selectByExample(GoodsWhoApplyExample example);

    GoodsWhoApply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsWhoApply record, @Param("example") GoodsWhoApplyExample example);

    int updateByExample(@Param("record") GoodsWhoApply record, @Param("example") GoodsWhoApplyExample example);

    int updateByPrimaryKeySelective(GoodsWhoApply record);

    int updateByPrimaryKey(GoodsWhoApply record);
}