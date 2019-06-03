package goods.mapper;

import goods.pojo.GoodsApplyPersonal;
import goods.pojo.GoodsApplyPersonalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsApplyPersonalMapper {
    long countByExample(GoodsApplyPersonalExample example);

    int deleteByExample(GoodsApplyPersonalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsApplyPersonal record);

    int insertSelective(GoodsApplyPersonal record);

    List<GoodsApplyPersonal> selectByExample(GoodsApplyPersonalExample example);

    GoodsApplyPersonal selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsApplyPersonal record, @Param("example") GoodsApplyPersonalExample example);

    int updateByExample(@Param("record") GoodsApplyPersonal record, @Param("example") GoodsApplyPersonalExample example);

    int updateByPrimaryKeySelective(GoodsApplyPersonal record);

    int updateByPrimaryKey(GoodsApplyPersonal record);
}