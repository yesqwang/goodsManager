package goods.mapper;

import goods.pojo.BuyList;
import goods.pojo.BuyListExample;
import java.util.List;

import goods.vo.PageBuyLists;
import org.apache.ibatis.annotations.Param;

public interface BuyListMapper {
    long countByExample(BuyListExample example);

    int deleteByExample(BuyListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BuyList record);

    int insertSelective(BuyList record);

    List<BuyList> selectByExample(BuyListExample example);

    BuyList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BuyList record, @Param("example") BuyListExample example);

    int updateByExample(@Param("record") BuyList record, @Param("example") BuyListExample example);

    int updateByPrimaryKeySelective(BuyList record);

    int updateByPrimaryKey(BuyList record);

    List<PageBuyLists> getPids(@Param("limit") int limit, @Param("offset")int offset, @Param("search") String search, @Param("order") String order);

    //统计
    Integer sumAllStore();
    Integer countAllKinds();
    Integer countAllStore();
    Integer countAllBorrow();
    Integer sumAllBorrow();

    Integer countAllApply();
    Integer countAllNoBuying();
    Integer countAllBuying();
    Integer countAllNoCompleteBuy();
    Integer countBuyList();

    Integer countNormalUser();
    Integer countManagerUser();
    Integer countAllCompany();
    Integer countBrand();
    Integer countGoodsUser();


    Integer countPids();
}