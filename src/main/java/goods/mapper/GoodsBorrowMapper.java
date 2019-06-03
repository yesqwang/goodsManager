package goods.mapper;

import goods.pojo.GoodsBorrow;
import goods.pojo.GoodsBorrowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsBorrowMapper {
    long countByExample(GoodsBorrowExample example);

    int deleteByExample(GoodsBorrowExample example);

    int deleteByPrimaryKey(Integer gbid);

    int insert(GoodsBorrow record);

    int insertSelective(GoodsBorrow record);

    List<GoodsBorrow> selectByExample(GoodsBorrowExample example);

    GoodsBorrow selectByPrimaryKey(Integer gbid);

    int updateByExampleSelective(@Param("record") GoodsBorrow record, @Param("example") GoodsBorrowExample example);

    int updateByExample(@Param("record") GoodsBorrow record, @Param("example") GoodsBorrowExample example);

    int updateByPrimaryKeySelective(GoodsBorrow record);

    int updateByPrimaryKey(GoodsBorrow record);
}