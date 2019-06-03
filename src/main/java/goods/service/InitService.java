package goods.service;

import goods.pojo.Company;
import goods.pojo.GoodsKind;
import goods.vo.GraphBar;
import goods.vo.GraphItem;
import goods.vo.PageGoodsKind;
import goods.vo.PageUserShow;

import java.util.List;

/**
 * @author 王业权
 * @功能 初始化页面参数
 * @time 2019/3/12 13:34
 */
public interface InitService {
    /**
     * 获取所有物品类型
     * @return
     */
    public List<String> getAllGoodsKind();

    /**
     * 获取所有物品品牌名称
     * @return
     */
    public List<String> getAllGoodsBrands();

    /**
     * 获取物品单位
     * @return
     */
    public List<String> getAllGoodsUnit();

    /**
     * 获取物品使用对象
     * @return
     */
    public List<String> getAllGoodsUser();

    List<Company> getCompanyList(int page, int limit, String field, String order);

    int getCompanyCount();

    boolean deleteCompany(int id);

    boolean insertCompany(Company company);

    boolean updateCompany(Company company);

    List<String> getAllCompany();

    List<String> getCompanyMessage(String com);

    List<GraphItem> getGraphBar();

    boolean deleteKinds(String name);

    boolean addKinds(PageGoodsKind kind);
}
