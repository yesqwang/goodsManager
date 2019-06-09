package goods.service.impl;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import goods.mapper.*;
import goods.pojo.*;
import goods.service.InitService;
import goods.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 王业权
 * @功能
 * @time 2019/3/12 13:36
 */
@Service("initService")
public class InitServiceImpl implements InitService {

    @Autowired
    GoodsKindMapper goodsKindMapper;
    @Autowired
    GoodsBrandMapper goodsBrandMapper;
    @Autowired
    GoodsUnitMapper goodsUnitMapper;
    @Autowired
    GoodsUserMapper goodsUserMapper;
    @Autowired
    CompanyMapper companyMapper;
    @Autowired
    GoodsStoreMapper storeMapper;
    @Autowired
    BuyListMapper buyListMapper;

    @Override
    public List<String> getAllGoodsKind() {
        List<GoodsKind> goodsKinds = goodsKindMapper.selectByExample(new GoodsKindExample());
        List<String> kindNames = new LinkedList<String>();
        for(GoodsKind kind:goodsKinds){
            kindNames.add(kind.getKindName());
        }
        return kindNames;
    }

    @Override
    public List<String> getAllGoodsBrands() {
        List<GoodsBrand> goodsBrands = goodsBrandMapper.selectByExample(new GoodsBrandExample());
        List<String> kindNames = new LinkedList<String>();
        for(GoodsBrand brand:goodsBrands){
            kindNames.add(brand.getBrandName());
        }
        return kindNames;
    }

    @Override
    public List<String> getAllGoodsUnit() {
        List<GoodsUnit> goodsUnits = goodsUnitMapper.selectByExample(new GoodsUnitExample());
        List<String> kindNames = new LinkedList<String>();
        for(GoodsUnit unit:goodsUnits){
            kindNames.add(unit.getUnitName());
        }
        return kindNames;
    }

    @Override
    public List<String> getAllGoodsUser() {
        List<GoodsUser> goodsUsers = goodsUserMapper.selectByExample(new GoodsUserExample());
        List<String> kindNames = new LinkedList<String>();
        for(GoodsUser user:goodsUsers){
            kindNames.add(user.getGoodsUserName());
        }
        return kindNames;
    }

    @Override
    public List<Company> getCompanyList(int page, int limit, String field, String order) {
        CompanyExample example = new CompanyExample();
        example.setOffset((page-1)*limit);
        example.setLimit(limit);
        example.setOrderByClause(field + " " + order);
        return companyMapper.selectByExample(example);
    }

    @Override
    public int getCompanyCount() {
        CompanyExample example = new CompanyExample();
        return (int)companyMapper.countByExample(example);
    }

    @Override
    public boolean deleteCompany(int id) {
        companyMapper.deleteByPrimaryKey(id);
        return true;
    }

    @Override
    public boolean insertCompany(Company company) {
        companyMapper.insert(company);
        return true;
    }

    @Override
    public boolean updateCompany(Company company) {
        companyMapper.updateByPrimaryKeySelective(company);
        return true;
    }

    @Override
    public List<String> getAllCompany() {
        List<Company> list = companyMapper.selectByExample(new CompanyExample());
        List<String> ret = new LinkedList<>();
        for (Company company : list){
            ret.add(company.getCompanyName());
        }
        return ret;
    }

    @Override
    public List<String> getCompanyMessage(String com) {
        CompanyExample example = new CompanyExample();
        CompanyExample.Criteria criteria = example.createCriteria();
        criteria.andCompanyNameEqualTo(com);
        List<Company> list = companyMapper.selectByExample(example);
        List<String> ret = new LinkedList<>();
        if (list.size() > 0){
            Company company = list.get(0);
            ret.add(company.getUserName());
            ret.add(company.getUserPhone());
        }
        return ret;
    }

    public void initGraphList(List<GraphItem> list, String name, Integer value){
        GraphItem item = new GraphItem();
        item.setName(name);
        item.setValue(value == null ? 0 : value);
        list.add(item);
    }

    @Override
    public List<GraphItem> getGraphBar() {
        List<GraphItem> list = new LinkedList<>();
        initGraphList(list, "库存总数", buyListMapper.sumAllStore());
        initGraphList(list, "物品种数", buyListMapper.countAllStore());
        initGraphList(list, "类型种数", buyListMapper.countAllKinds());
        initGraphList(list, "借出种数", buyListMapper.countAllBorrow());
        initGraphList(list, "借出总数", buyListMapper.sumAllBorrow());
        initGraphList(list, "正在申请总数", buyListMapper.countAllApply());
        initGraphList(list, "未采购总数", buyListMapper.countAllNoBuying());
        initGraphList(list, "正在采购总数", buyListMapper.countAllBuying());
        initGraphList(list, "未完全采购总数", buyListMapper.countAllNoCompleteBuy());
        initGraphList(list, "采购清单总数", buyListMapper.countBuyList());
        initGraphList(list, "普通用户数量", buyListMapper.countNormalUser());
        initGraphList(list, "物管员数量", buyListMapper.countManagerUser());
        initGraphList(list, "采购公司数量", buyListMapper.countAllCompany());
        initGraphList(list, "物品品牌数量", buyListMapper.countBrand());
        initGraphList(list, "使用对象数量", buyListMapper.countGoodsUser());

        return list;
    }

    @Override
    public boolean deleteKinds(String name) {
        if(name == null || name.trim().equals("")){
            return false;
        }
        //如果不存在，则不进行删除
        GoodsKindExample example = new GoodsKindExample();
        GoodsKindExample.Criteria criteria = example.createCriteria();
        criteria.andKindNameEqualTo(name);
        List<GoodsKind> list = goodsKindMapper.selectByExample(example);
        if(list.size() == 0){
            return false;
        }
        //如果其它表有其引用，则不删除
        //GoodsStoreMapper
        //数据库有外键约束，必须删除子表数据才可以删除成功
        example = new GoodsKindExample();
        criteria = example.createCriteria();
        criteria.andKindNameEqualTo(name);
        return goodsKindMapper.deleteByExample(example) > 0;
    }

    @Override
    public boolean addKinds(PageGoodsKind kind) {
        if(kind == null || kind.getKindName().trim().equals("")){
            return false;
        }
        //如果存在，则不进行插入
        GoodsKindExample example = new GoodsKindExample();
        GoodsKindExample.Criteria criteria = example.createCriteria();
        criteria.andKindNameEqualTo(kind.getKindName());
        List<GoodsKind> list = goodsKindMapper.selectByExample(example);
        if(list.size() > 0){
            return false;
        }
        GoodsKind goodsKind = new GoodsKind();
        goodsKind.setKindName(kind.getKindName());
        return goodsKindMapper.insert(goodsKind) > 0;
    }

    @Override
    public OutputStream getExportModelFileOutputStream() {
        OutputStream out = new ByteArrayOutputStream();
        List<ExportModelFile> list = new LinkedList<>();
        ExportModelFile demoFile = new ExportModelFile();
        demoFile.setKind("橡皮擦");
        demoFile.setName("xx橡皮擦");
        demoFile.setBrand("晨光");
        demoFile.setModel("");
        demoFile.setParams("30*50mm");
        demoFile.setUnit("只");
        demoFile.setNumber("10");
        list.add(demoFile);

        try {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX,true);
            Sheet sheet1 = new Sheet(1, 0,ExportModelFile.class);
            sheet1.setSheetName("添加库存");
            writer.write(list, sheet1);
            writer.finish();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return out;
    }
}
