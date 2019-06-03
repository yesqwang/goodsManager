package goods.service;

import goods.vo.PageBuyListItem;
import goods.vo.PageGoodsApply;
import goods.vo.PageGoodsApplyPersonal;

import java.text.ParseException;
import java.util.List;

/**
 * @author 王业权
 * @功能
 * @time 2019/3/12 11:56
 */
public interface GoodsApplyService {

    /**
     * 添加个人采购申请内容
     * @param applyPersonal
     * @return
     */
    public boolean addPersonalApply(PageGoodsApplyPersonal applyPersonal, String userid);

    /**
     * 获取个人物品申请表
     * @param page
     * @param limit
     * @return
     */
    public List<PageGoodsApplyPersonal> getGoodsApplyPersonalList(String userid, int page, int limit, String  field, String order, String search);

    /**
     * 获取个人物品申请表总数
     * @param userid
     * @return
     */
    public int getPersonApplyCount(String userid);

    /**
     * 将个人物品申请表的内容复制到申请总表中
     * @param ids
     * @return
     */
    public boolean copyPersonalApplyToApply(Integer[] ids);

    /**
     * 获取申请总表列表
     * @param page
     * @param limit
     * @return
     */
    public List<PageGoodsApply> getGoodsApplyList(int page, int limit, String  field, String order, String search);

    /**
     * 获取申请总表列表总数
     * @return
     */
    public int getApplyCount();

    /**
     * 将申请总表的内容复制到采购总表里去
     * @param ids
     * @return
     */
    public boolean copyApplyToBuy(Integer[] ids);

    /**
     * 将采购总表的物品添加到个人申请表里
     * @param userid
     * @param ids
     * @return
     */
    public boolean copyBuyToPersonalApply(String userid, Integer[] ids);

    /**
     * 将申请总表的内容复添加道个人申请表里
     * @param userid
     * @param ids
     * @return
     */
    public boolean copyApplyToPersonalApply(String userid, Integer[] ids);

    /**
     * 根据id删除个人申请表
     * @param id
     * @return
     */
    public boolean deletePersonalApplyById(int id);

    /**
     * 根据id批量删除个人申请表
     * @param ids
     * @return
     */
    public boolean deletePersonalApplyByIds(Integer[] ids);

    /**
     * 获取个人提交到申请总表上的数据
     * @param user
     * @param page
     * @param limit
     * @return
     */
    public List<PageGoodsApply> getWhoApplyList(String user, int page, int limit);

    /**
     * 计算个人提交到申请总表上的数据的总数
     * @param user
     * @return
     */
    public int getWhoApplyCount(String user);

    /**
     * 根据id获取申请物品信息
     * @param id
     * @return
     */
    public PageGoodsApplyPersonal getGoodsApplyById(int id);

    /**
     * 修改个人申请物品的参数
     * @param personal
     * @return
     */
    public boolean updatePersonalApply(PageGoodsApplyPersonal personal);

    /**
     * 删除申请总表的数据
     * @param gid
     * @return
     */
    public boolean deleteApply(int gid);

    /**
     * 批量删除申请总表的数据
     * @param ids
     * @return
     */
    public boolean deleteApplyByIds(Integer[] ids);

    /**
     * 合并申请表
     * @param ids
     * @return
     */
    public boolean combineApplys(PageGoodsApply apply, int[] ids);

    /**
     * 批量添加个人申请
     * @param datas
     * @param user
     * @return
     */
    public boolean addPersonalApplys(List<PageGoodsApplyPersonal>  datas, String user);

    /**
     * 根据id获取申请内容
     * @param id
     * @return
     */
    public PageGoodsApply getApplyMessageById(int id);

    /**
     * 编辑申请信息
     * @param pageGoodsApply
     * @return
     */
    boolean editApply(PageGoodsApply pageGoodsApply);

    /**
     * 添加到采购清单里
     * @param list
     * @return
     */
    boolean toBuyGoods(List<PageBuyListItem> list) throws ParseException;


}
