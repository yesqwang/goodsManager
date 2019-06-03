package goods.mapper;

import goods.pojo.UserIdentityExample;
import goods.pojo.UserIdentityKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserIdentityMapper {
    long countByExample(UserIdentityExample example);

    int deleteByExample(UserIdentityExample example);

    int deleteByPrimaryKey(UserIdentityKey key);

    int insert(UserIdentityKey record);

    int insertSelective(UserIdentityKey record);

    List<UserIdentityKey> selectByExample(UserIdentityExample example);

    int updateByExampleSelective(@Param("record") UserIdentityKey record, @Param("example") UserIdentityExample example);

    int updateByExample(@Param("record") UserIdentityKey record, @Param("example") UserIdentityExample example);
}