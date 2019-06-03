package goods.mapper;

import goods.pojo.Identitys;
import goods.pojo.IdentitysExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IdentitysMapper {
    long countByExample(IdentitysExample example);

    int deleteByExample(IdentitysExample example);

    int deleteByPrimaryKey(Integer iid);

    int insert(Identitys record);

    int insertSelective(Identitys record);

    List<Identitys> selectByExample(IdentitysExample example);

    Identitys selectByPrimaryKey(Integer iid);

    int updateByExampleSelective(@Param("record") Identitys record, @Param("example") IdentitysExample example);

    int updateByExample(@Param("record") Identitys record, @Param("example") IdentitysExample example);

    int updateByPrimaryKeySelective(Identitys record);

    int updateByPrimaryKey(Identitys record);
}