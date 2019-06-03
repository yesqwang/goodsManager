package goods.service;

import goods.vo.*;
import org.springframework.transaction.annotation.Transactional;

import java.io.OutputStream;
import java.text.ParseException;
import java.util.List;

/**
 * @author 王业权
 * @功能
 * @time 2019/3/13 11:06
 */
public interface GoodsBuyService {


    /**
     * 分页获取物品采购总表
     * @param page
     * @param limit
     * @return
     */
    public List<PageGoodsBuy> getGoodsBuyList(int page, int limit, String  field, String order, String search);

    /**
     * 获取物品采购总表的总数量
     * @return
     */
    public int getBuyCount();

    /**
     * 批量添加采购列表到库存表
     * @param ids
     * @return
     */
    public boolean copyBuyToStore(Integer[] ids);


    List<PageBuyLists> getBuyListItemList(int page, int limit, String field, String order, String search);

    int getBuyListItemCount();

    /**
     * 获取清单详情列表
     * @param page
     * @param limit
     * @param pid
     * @return
     */
    List<PageBuyListItem> listBuyListItem(int page, int limit, String pid) throws ParseException;

    /**
     * 计算清单列表的数量
     * @param pid
     * @return
     */
    int getBuyListCount(String pid) throws ParseException;

    /**
     * 获取所有指定批号的清单信息
     * @param pid
     * @return
     */
    List<PageBuyListItem> listBuyListItem(String pid) throws ParseException;

    /**
     * 确定购买采购清单的物品，并导出Excel表格
     * @param pid
     * @return
     */
    OutputStream sureBuyList(String pid) throws ParseException;

    /**
     * 物品入库
     * @param store
     * @return
     */
    boolean insertIntoStore(PageGoodsStore store);

}
