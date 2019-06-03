package goods.mapper;

import goods.pojo.GoodsUser;
import goods.pojo.GoodsUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsUserMapper {
    long countByExample(GoodsUserExample example);

    int deleteByExample(GoodsUserExample example);

    int deleteByPrimaryKey(Integer guid);

    int insert(GoodsUser record);

    int insertSelective(GoodsUser record);

    List<GoodsUser> selectByExample(GoodsUserExample example);

    GoodsUser selectByPrimaryKey(Integer guid);

    int updateByExampleSelective(@Param("record") GoodsUser record, @Param("example") GoodsUserExample example);

    int updateByExample(@Param("record") GoodsUser record, @Param("example") GoodsUserExample example);

    int updateByPrimaryKeySelective(GoodsUser record);

    int updateByPrimaryKey(GoodsUser record);
}