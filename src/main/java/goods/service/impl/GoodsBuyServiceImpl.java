package goods.service.impl;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import goods.mapper.*;
import goods.pojo.*;
import goods.service.GoodsApplyService;
import goods.service.GoodsBuyService;
import goods.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 王业权
 * @功能
 * @time 2019/3/13 11:07
 */
@Service("goodsBuyService")
@Transactional
public class GoodsBuyServiceImpl implements GoodsBuyService {

    @Autowired
    GoodsApplyService goodsApplyService;

    @Autowired
    GoodsBuyMapper goodsBuyMapper;
    @Autowired
    GoodsStoreMapper goodsStoreMapper;
    @Autowired
    GoodsApplyService applyService;
    @Autowired
    CompanyMapper companyMapper;
    @Autowired
    BuyListMapper buyListMapper;
    @Autowired
    ApplyBuylistMapper applyBuylistMapper;
    @Autowired
    GoodsApplyMapper applyMapper;

    @Override
    public List<PageGoodsBuy> getGoodsBuyList(int page, int limit, String  field, String order, String search) {
        GoodsApplyServiceImpl applyService = (GoodsApplyServiceImpl)goodsApplyService;
        GoodsBuyExample example = new GoodsBuyExample();
        GoodsBuyExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsNameLike("%" +search+ "%");

        example.setOffset((page-1)*limit);
        example.setLimit(limit);
        example.setOrderByClause(PageGoodsBuy.getDbColName(field) + " " + order);
        List<GoodsBuy> buys = goodsBuyMapper.selectByExample(example);
        List<PageGoodsBuy> list = new LinkedList<>();
        for(GoodsBuy buy : buys){
            PageGoodsBuy pbuy = new PageGoodsBuy();
            pbuy.setGoodsId(buy.getGbid());
            pbuy.setGoodsName(buy.getGoodsName());
            pbuy.setGoodsKind(applyService.getGoodsKindById(buy.getGoodsKind()).getKindName());
            pbuy.setGoodsBrand(applyService.getGoodsBrandById(buy.getGoodsBrand()).getBrandName());
            pbuy.setGoodsModel(buy.getGoodsModel());
            pbuy.setGoodsPram(buy.getGoodsParm());
            pbuy.setGoodsUnit(applyService.getGoodsUnitById(buy.getGoodsUnit()).getUnitName());
            pbuy.setGoodsNumber(buy.getGoodsNumber());
            pbuy.setGoodsPrice(buy.getGoodsPrice());
            pbuy.setWhoUses(applyService.getGoodsUserById(buy.getWhoToUse()).getGoodsUserName());
            pbuy.setWhatToDo(buy.getWhatToDo());
            pbuy.setUrl(buy.getUrl());
            pbuy.setNote(buy.getNote());
            pbuy.setStatus(buy.getStatus());
            pbuy.setRealBuyNumber(buy.getRealBuyNumber() == null ? 0 : buy.getRealBuyNumber());

            list.add(pbuy);
        }

        return list;
    }

    @Override
    public int getBuyCount() {
        long count = goodsBuyMapper.countByExample(new GoodsBuyExample());
        return (int)count;
    }

    @Override
    public boolean copyBuyToStore(Integer[] ids) {
        for (int id : ids){
            GoodsBuy buy = goodsBuyMapper.selectByPrimaryKey(id);
            GoodsStore store = new GoodsStore();
            store.setGoodsName(buy.getGoodsName());
            store.setGoodsKind(buy.getGoodsKind());
            store.setGoodsBrand(buy.getGoodsBrand());
            store.setGoodsModel(buy.getGoodsModel());
            store.setGoodsParm(buy.getGoodsParm());
            store.setGoodsUnit(buy.getGoodsUnit());
            store.setGoodsNumber(buy.getGoodsNumber());
            store.setGoodsGiveNumber(0);
            store.setGoodsBorrowNumber(0);

            goodsStoreMapper.insert(store);
        }
        return true;
    }

    public Company getCompanyById(int id){
        return companyMapper.selectByPrimaryKey(id);
    }


    public PageBuyListItem changeBuyListToPageBuyListItem(BuyList buy){
        GoodsApplyServiceImpl service = (GoodsApplyServiceImpl)applyService;
        PageBuyListItem item = new PageBuyListItem();

        item.setGoodsName(buy.getGoodsName());
        item.setGoodsKind(service.getGoodsKindById(buy.getGoodsKind()).getKindName());
        item.setGoodsBrand(service.getGoodsBrandById(buy.getGoodsBrand()).getBrandName());
        item.setGoodsModel(buy.getGoodsModel());
        item.setGoodsParm(buy.getGoodsParm());
        item.setGoodsNumber(buy.getGoodsNumber());
        item.setGoodsPrice(buy.getGoodsPrice());
        item.setGoodsUnit(service.getGoodsUnitById(buy.getGoodsUnit()).getUnitName());
        item.setComplanyName(getCompanyById(buy.getBuyCompany()).getCompanyName());
        Date cdate = buy.getCompleteDate();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        item.setCompliteDate(cdate == null ? "" : format.format(cdate));
        item.setcUser(buy.getUser());
        item.setPhone(buy.getPhone());
        item.setNote(buy.getNote());
        item.setPid(format.format(buy.getPid()));
        item.setWillCompliteDate(format.format(buy.getWillCompleteDate()));
        Integer num = buy.getRealBuyNumber();
        item.setRealBuyNumber(num == null ? 0 : num);
        item.setStatus(buy.getCompleteStatus());
        item.setId(buy.getId());

        return item;
    }

    @Override
    public List<PageBuyLists> getBuyListItemList(int page, int limit, String field, String order, String search) {
        List<PageBuyLists> ls = buyListMapper.getPids((page-1)*limit, limit, "%"+search+"%", field+" "+order );
        System.out.println(ls);
        return ls;
    }

    @Override
    public int getBuyListItemCount() {
        return buyListMapper.countPids();
    }

    @Override
    public List<PageBuyListItem> listBuyListItem(int page, int limit, String pid) throws ParseException {
        BuyListExample example = new BuyListExample();
        BuyListExample.Criteria criteria = example.createCriteria();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("pid=" + pid);
        Date d = format.parse(pid);
        criteria.andPidEqualTo(d);
        //example.setLimit(limit);
        //example.setOffset((page-1)*limit);
        List<BuyList> list = buyListMapper.selectByExample(example);
        List<PageBuyListItem> items = new LinkedList<>();
        for (BuyList buy : list){
            PageBuyListItem item = changeBuyListToPageBuyListItem(buy);
            items.add(item);
        }

        return items;
    }

    @Override
    public int getBuyListCount(String pid) throws ParseException {
        BuyListExample example = new BuyListExample();
        BuyListExample.Criteria criteria = example.createCriteria();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("pid=" + pid);
        criteria.andPidEqualTo(format.parse(pid));
        long count = buyListMapper.countByExample(example);
        return (int)count;
    }

    @Override
    public List<PageBuyListItem> listBuyListItem(String pid) throws ParseException {
        BuyListExample example = new BuyListExample();
        BuyListExample.Criteria criteria = example.createCriteria();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("pid=" + pid);
        criteria.andPidEqualTo(format.parse(pid));
        List<BuyList> list = buyListMapper.selectByExample(example);
        List<PageBuyListItem> items = new LinkedList<>();
        for (BuyList buy : list){
            PageBuyListItem item = changeBuyListToPageBuyListItem(buy);
            items.add(item);
        }

        return items;
    }

    @Override
    public OutputStream sureBuyList(String pid) throws ParseException {
        OutputStream out = new ByteArrayOutputStream();
        List<PageBuyListItem> list = listBuyListItem(pid);
        try {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX,true);
            Sheet sheet1 = new Sheet(1, 0,PageBuyListItem.class);
            sheet1.setSheetName("采购清单详情");
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
        BuyList buy = new BuyList();
        buy.setCompleteStatus(GoodsApplyServiceImpl.GOODS_STATUS_BUYING);
        BuyListExample example = new BuyListExample();
        BuyListExample.Criteria criteria = example.createCriteria();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("pid=" + pid);
        criteria.andPidEqualTo(format.parse(pid));
        buyListMapper.updateByExampleSelective(buy, example);

        return out;
    }

    @Override
    public boolean insertIntoStore(PageGoodsStore pstore) {
        GoodsApplyServiceImpl applyService = (GoodsApplyServiceImpl)goodsApplyService;
        System.out.println(pstore);
        int id = pstore.getGoodsId();
        BuyList buy = buyListMapper.selectByPrimaryKey(id);
        //插入库存表
        GoodsStore store = new GoodsStore();
        store.setGoodsName(pstore.getGoodsName());
        store.setGoodsKind(buy.getGoodsKind());
        store.setGoodsBrand(applyService.getGoodsBrandByBrandName(pstore.getGoodsBrand()).getBid());
        store.setGoodsModel(pstore.getGoodsModel());
        store.setGoodsParm(pstore.getGoodsPram());
        store.setGoodsUnit(applyService.getGoodsUnitByUnitName(pstore.getGoodsUnit()).getUnid());
        int number = pstore.getGoodsNumber();
        store.setGoodsNumber(number);
        store.setGoodsGiveNumber(0);
        store.setGoodsBorrowNumber(0);
        store.setNote(pstore.getNote());
        goodsStoreMapper.insert(store);

        //采购清单状态
        int rnumber = buy.getRealBuyNumber() == null ? 0 : buy.getRealBuyNumber();
        int wnumber = buy.getGoodsNumber();
        String status = rnumber + number == wnumber ? GoodsApplyServiceImpl.GOODS_STATUS_BUY_SUCCESS : GoodsApplyServiceImpl.GOODS_STATUS_BUY_SOME;
        buy.setCompleteStatus(status);
        buy.setRealBuyNumber(rnumber + number);
        buyListMapper.updateByPrimaryKeySelective(buy);

        //申请总表 和 采购总表
        ApplyBuylistExample example = new ApplyBuylistExample();
        ApplyBuylistExample.Criteria criteria = example.createCriteria();
        criteria.andBuylistidEqualTo(id);
        List<ApplyBuylist> applyBuylists = applyBuylistMapper.selectByExample(example);
        if(applyBuylists.size()>0){
            //申请总表状态
            int aid = applyBuylists.get(0).getApplyid();
            GoodsApply apply = applyMapper.selectByPrimaryKey(aid);
            apply.setApplyStatus(status);
            applyMapper.updateByPrimaryKeySelective(apply);

            //插入采购总表
            GoodsBuy goodsBuy = new GoodsBuy();
            goodsBuy.setGoodsName(store.getGoodsName());
            goodsBuy.setGoodsKind(store.getGoodsKind());
            goodsBuy.setGoodsBrand(store.getGoodsBrand());
            goodsBuy.setGoodsModel(store.getGoodsModel());
            goodsBuy.setGoodsParm(store.getGoodsParm());
            goodsBuy.setGoodsNumber(store.getGoodsNumber());
            goodsBuy.setGoodsUnit(store.getGoodsUnit());
            goodsBuy.setGoodsPrice(buy.getGoodsPrice());
            goodsBuy.setWhatToDo(apply.getWhatToDo());
            goodsBuy.setWhoToUse(apply.getWhoToUse());
            goodsBuy.setUrl(apply.getUrl());
            goodsBuy.setNote(store.getNote());

            goodsBuyMapper.insert(goodsBuy);
        }

        return true;
    }
}
