package goods.service;

import goods.vo.*;

import java.io.InputStream;
import java.text.ParseException;
import java.util.List;

/**
 * 物品库存方面的操作
 */
public interface GoodsStoreService {

    /**
     * 获取库存表
     * @param page
     * @param limit
     * @return
     */
    public List<PageGoodsStore> getStoreList(int page, int limit, String fied, String order, String search);

    /**
     * 统计库存表的数量
     * @return
     */
    public int getStoreCount();

    /**
     * 借出物品
     * @param user
     * @param gsid
     * @param gnumber
     * @return
     */
    public boolean addUserBorrowGoods(String user, int gsid, int gnumber, String gusername, String date) throws ParseException;

    /**
     * 领取物品
     * @param user
     * @param gsid
     * @param gnumber
     * @return
     */
    public boolean addUserGiveGoods(String user, int gsid, int gnumber, String gusername);

    /**
     * 获取用户领取列表
     * @param user
     * @param page
     * @param limit
     * @return
     */
    public List<PageGoodsGiveOrBorrow> getUserGiveOrBorrowList(String user, int page, int limit, String field, String order, String kinds);

    /**
     * 计算单个用户领取数量
     * @param user
     * @return
     */
    public int getUserGiveOrBorrowCount(String user, String kinds);

    /**
     * 添加库存
     * @param goodsStore
     * @return
     */
    public boolean addStore(PageGoodsStore goodsStore);

    /**
     * 删除
     * @param id
     * @return
     */
    public boolean deleteStore(int id);

    /**
     * 更新修改
     * @param store
     * @return
     */
    public boolean updateGoodsStore(PageGoodsStore store);

    /**
     * 获取全部借出/领取列表
     * @param isBorrow
     * @param page
     * @param limit
     * @param field
     * @param order
     * @return
     */
    public List<PageGoodsGiveOrBorrow> getGoodsBorrowOrGiveList(boolean isBorrow, int page, int limit, String field, String order, String search);

    /**
     * 统计所有借出/领取的数量
     * @param isBorrow
     * @return
     */
    public int getBorrowOrGiveCount(boolean isBorrow);

    /**
     * 通过借出/领取申请
     * @param gbid
     * @return
     */
    /*public boolean passBorrowOrGive(int gbid);*/

    /**
     * 取消同意借出/领取申请
     * @param gbid
     * @return
     */
   /* public boolean cancelPassBorrowOrGive(int gbid);*/

    /**
     * 记录物品借出/领取出
     * @param gbid
     * @return
     */
    public boolean outBorrowOrGive(int gbid);

    /**
     * 归还已借出物品
     * @param gbid
     * @return
     */
    public boolean returnBorrow(int gbid);

    /**
     * 报废物品
     * @param gsid
     * @param gnumber
     * @return
     */
    public boolean scrapGoods(int gsid, int gnumber);

    /**
     * 批量添加借出/领取
     * @param list
     * @return
     */
    public boolean borrowOrGive(List<PageGoodsBorrowGive> list) throws ParseException;

    /**
     * 批量报废物品
     * @param list
     * @return
     */
    public boolean scrapGoods(List<PageGoodsScrap> list);

    /**
     * 归还物品
     * @param goodsId
     * @param returnNumber
     * @param returnUser
     * @param note
     * @return
     */
    boolean returnBorrow(int goodsId, int returnNumber, String returnUser, String note);

    /**
     * 获取所有领取和借出记录
     * @param page
     * @param limit
     * @param field
     * @param order
     * @return
     */
    List<PageGoodsGiveOrBorrow> getAllGoodsBorrowOrGiveList(int page, int limit, String field, String order, String search, String kind);

    /**
     * 解析导入文件
     * @param is
     */
    void pauseExportModelFile(InputStream is, String filename);
}
