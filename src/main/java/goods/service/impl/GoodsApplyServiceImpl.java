package goods.service.impl;

import goods.mapper.*;
import goods.pojo.*;
import goods.service.GoodsApplyService;
import goods.vo.PageBuyListItem;
import goods.vo.PageGoodsApply;
import goods.vo.PageGoodsApplyPersonal;
import goods.vo.PageListApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 王业权
 * @功能
 * @time 2019/3/12 11:58
 */
@Service("goodsApplyService")
@Transactional
public class GoodsApplyServiceImpl implements GoodsApplyService {

    public static String GOODS_STATUS_APPLY = "正在申请";
    public static String GOODS_STATUS_NO_BUY = "未采购";
    public static String GOODS_STATUS_BUYING = "正在采购";
    public static String GOODS_STATUS_BUY_SOME = "部分完成";
    public static String GOODS_STATUS_BUY_SUCCESS = "完成";
    public static String GOODS_STATUS_BUY_FAILURE = "采购失败";

    @Autowired
    GoodsApplyPersonalMapper goodsApplyPersonalMapper;
    @Autowired
    GoodsBrandMapper goodsBrandMapper;
    @Autowired
    GoodsKindMapper goodsKindMapper;
    @Autowired
    GoodsUnitMapper goodsUnitMapper;
    @Autowired
    GoodsUserMapper goodsUserMapper;
    @Autowired
    GoodsApplyMapper goodsApplyMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    GoodsBuyMapper goodsBuyMapper;
    @Autowired
    GoodsWhoApplyMapper whoApplyMapper;
    @Autowired
    CompanyMapper companyMapper;
    @Autowired
    BuyListMapper buyListMapper;
    @Autowired
    ApplyBuylistMapper applyBuylistMapper;

    private GoodsApplyPersonal changePageApplyPersonToGoodsApplyPerson(PageGoodsApplyPersonal applyPersonal){
        GoodsApplyPersonal goodsApplyPersonal = new GoodsApplyPersonal();
        goodsApplyPersonal.setGoodsModel(applyPersonal.getGoodsModel());
        goodsApplyPersonal.setGoodsName(applyPersonal.getGoodsName());
        goodsApplyPersonal.setGoodsNumber(applyPersonal.getGoodsNumber());
        goodsApplyPersonal.setGoodsParm(applyPersonal.getGoodsPram());
        goodsApplyPersonal.setGoodsUrl(applyPersonal.getUrl());
        goodsApplyPersonal.setGoodsPrice(applyPersonal.getGoodsPrice());
        goodsApplyPersonal.setNote(applyPersonal.getNote());
        goodsApplyPersonal.setWhatToDo(applyPersonal.getWhatToDo());
        goodsApplyPersonal.setGoodsBrand(getGoodsBrandByBrandName(applyPersonal.getGoodsBrand()).getBid());
        goodsApplyPersonal.setGoodsKind(getGoodsKindByKindName(applyPersonal.getGoodsKind()).getKid());
        goodsApplyPersonal.setWhoUse(getGoodsUserByName(applyPersonal.getWhoUses()).getGuid());
        goodsApplyPersonal.setGoodsUnit(getGoodsUnitByUnitName(applyPersonal.getGoodsUnit()).getUnid());
        goodsApplyPersonal.setApplyCount(applyPersonal.getApplyCount());

        return goodsApplyPersonal;
    }

    @Override
    public boolean addPersonalApply(PageGoodsApplyPersonal applyPersonal, String userid) {

        //GoodsApplyPersonal goodsApplyPersonal = new GoodsApplyPersonal();
        GoodsApplyPersonal goodsApplyPersonal = changePageApplyPersonToGoodsApplyPerson(applyPersonal);
        goodsApplyPersonal.setApplyUser(userid);
        goodsApplyPersonalMapper.insert(goodsApplyPersonal);
        return true;
    }

    /**
     * 根据品牌名称获取品牌对象，若找不到则插入
     * @param bname
     * @return
     */
    public synchronized GoodsBrand getGoodsBrandByBrandName(String bname){
        GoodsBrandExample example = new GoodsBrandExample();
        GoodsBrandExample.Criteria criteria = example.createCriteria();
        criteria.andBrandNameEqualTo(bname);
        List<GoodsBrand> list = goodsBrandMapper.selectByExample(example);
        if (list.size()>0){
            return list.get(0);
        }else {
            GoodsBrand brand = new GoodsBrand();
            brand.setBrandName(bname);
            goodsBrandMapper.insert(brand);
            return getGoodsBrandByBrandName(bname);
        }
    }

    /**
     * 根据类型名称获取类型对象，找不到则插入
     * @param kname
     * @return
     */
    public synchronized GoodsKind getGoodsKindByKindName(String kname){
        GoodsKindExample example = new GoodsKindExample();
        GoodsKindExample.Criteria criteria = example.createCriteria();
        criteria.andKindNameEqualTo(kname);
        List<GoodsKind> list = goodsKindMapper.selectByExample(example);
        if (list.size()>0){
            return list.get(0);
        }else {
            GoodsKind kind = new GoodsKind();
            kind.setKindName(kname);
            goodsKindMapper.insert(kind);
            return getGoodsKindByKindName(kname);
        }
    }

    /**
     * 根据单位名称获取单位对象，若找不到则插入
     * @param uname
     * @return
     */
    public synchronized GoodsUnit getGoodsUnitByUnitName(String uname){
        GoodsUnitExample example = new GoodsUnitExample();
        GoodsUnitExample.Criteria criteria = example.createCriteria();
        criteria.andUnitNameEqualTo(uname);
        List<GoodsUnit> list = goodsUnitMapper.selectByExample(example);
        if (list.size()>0){
            return list.get(0);
        }else {
            GoodsUnit unit = new GoodsUnit();
            unit.setUnitName(uname);
            goodsUnitMapper.insert(unit);
            return getGoodsUnitByUnitName(uname);
        }
    }

    /**
     * 根据使用对象名称获取使用对象，若不存在返回null
     * @param uname
     * @return
     */
    public GoodsUser getGoodsUserByName(String uname){
        GoodsUserExample example = new GoodsUserExample();
        GoodsUserExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsUserNameEqualTo(uname);
        List<GoodsUser> list = goodsUserMapper.selectByExample(example);
        if (list.size()>0){
            return list.get(0);
        }else {
           return null;
        }
    }

    /**
     * 根据物品类型id获取物品类型对象
     * @param gid
     * @return
     */
    public GoodsKind getGoodsKindById(int gid){
        return goodsKindMapper.selectByPrimaryKey(gid);
    }

    /**
     * 根据品牌id获取品牌对象
     * @param bid
     * @return
     */
    public GoodsBrand getGoodsBrandById(int bid){
        return goodsBrandMapper.selectByPrimaryKey(bid);
    }

    /**
     * 根据单位id获取单位对象
     * @param uid
     * @return
     */
    public GoodsUnit getGoodsUnitById(int uid){
        return goodsUnitMapper.selectByPrimaryKey(uid);
    }

    /**
     * 根据物品使用对象id查找物品使用对象
     * @param guid
     * @return
     */
    public GoodsUser getGoodsUserById(int guid){
        return goodsUserMapper.selectByPrimaryKey(guid);
    }

    /**
     * 将个人申请数据库对象转变成页面显示对象
     * @param goodsApplyPersonal
     * @return
     */
    private PageGoodsApplyPersonal changeGoodsApplyPersonalToPageGoodsApplyPersonal(GoodsApplyPersonal goodsApplyPersonal){
        PageGoodsApplyPersonal personal = new PageGoodsApplyPersonal();
        personal.setGoodsId(goodsApplyPersonal.getId());
        personal.setGoodsName(goodsApplyPersonal.getGoodsName());
        personal.setGoodsKind(getGoodsKindById(goodsApplyPersonal.getGoodsKind()).getKindName());
        personal.setGoodsBrand(getGoodsBrandById(goodsApplyPersonal.getGoodsBrand()).getBrandName());
        personal.setGoodsModel(goodsApplyPersonal.getGoodsModel());
        personal.setGoodsPram(goodsApplyPersonal.getGoodsParm());
        personal.setGoodsUnit(getGoodsUnitById(goodsApplyPersonal.getGoodsUnit()).getUnitName());
        personal.setGoodsNumber(goodsApplyPersonal.getGoodsNumber());
        personal.setGoodsPrice(goodsApplyPersonal.getGoodsPrice());
        personal.setWhoUses(getGoodsUserById(goodsApplyPersonal.getWhoUse()).getGoodsUserName());
        personal.setWhatToDo(goodsApplyPersonal.getWhatToDo());
        personal.setUrl(goodsApplyPersonal.getGoodsUrl());
        personal.setNote(goodsApplyPersonal.getNote());
        personal.setApplyer(goodsApplyPersonal.getApplyUser());
        personal.setApplyCount(goodsApplyPersonal.getApplyCount());
        return  personal;
    }

    @Override
    public List<PageGoodsApplyPersonal> getGoodsApplyPersonalList(String userid, int page, int limit, String  field, String order, String search) {
        GoodsApplyPersonalExample example = new GoodsApplyPersonalExample();
        GoodsApplyPersonalExample.Criteria criteria = example.createCriteria();
        criteria.andApplyUserEqualTo(userid);
        criteria.andGoodsNameLike("%" + search + "%");
        example.setOrderByClause(PageGoodsApply.getDbColName(field) + " " + order);
        System.out.println(PageGoodsApply.getDbColName(field) + " " + order);
        example.setOffset((page-1)*limit);
        example.setLimit(limit);
        List<GoodsApplyPersonal> list = goodsApplyPersonalMapper.selectByExample(example);
        List<PageGoodsApplyPersonal> glist = new LinkedList<>();
        for(GoodsApplyPersonal goodsApplyPersonal : list){
            PageGoodsApplyPersonal personal = changeGoodsApplyPersonalToPageGoodsApplyPersonal(goodsApplyPersonal);
            glist.add(personal);
        }
        return glist;
    }

    @Override
    public int getPersonApplyCount(String userid) {
        GoodsApplyPersonalExample example = new GoodsApplyPersonalExample();
        GoodsApplyPersonalExample.Criteria criteria = example.createCriteria();
        criteria.andApplyUserEqualTo(userid);
        long count = goodsApplyPersonalMapper.countByExample(example);
        return (int)count;
    }

    @Override
    public boolean copyPersonalApplyToApply(Integer[] ids) {
        List<Integer> idList = new LinkedList<>();
        for(int id : ids){
            GoodsApplyPersonal personal = goodsApplyPersonalMapper.selectByPrimaryKey(id);
            GoodsApply apply = new GoodsApply();
            apply.setGoodsName(personal.getGoodsName());
            apply.setGoodsKind(personal.getGoodsKind());
            apply.setGoodsBrand(personal.getGoodsBrand());
            apply.setGoodsModel(personal.getGoodsModel());
            apply.setGoodsParm(personal.getGoodsParm());
            apply.setGoodsUnit(personal.getGoodsUnit());
            apply.setGoodsNumber(personal.getGoodsNumber());
            apply.setGoodsPrice(personal.getGoodsPrice());
            apply.setWhoToUse(personal.getWhoUse());
            apply.setWhatToDo(personal.getWhatToDo());
            apply.setUrl(personal.getGoodsUrl());
            apply.setNote(personal.getNote());
            apply.setApplyUser(userMapper.selectByPrimaryKey(personal.getApplyUser()).getUserName() + personal.getGoodsNumber() + ";");
            apply.setApplyDate(new Date());
            apply.setApplyStatus(GOODS_STATUS_APPLY);

            personal.setApplyCount(personal.getApplyCount()+1);
            goodsApplyPersonalMapper.updateByPrimaryKeySelective(personal);

            int aid = goodsApplyMapper.insert(apply);
            GoodsWhoApply whoApply = new GoodsWhoApply();
            whoApply.setGoodsApplyer(personal.getApplyUser());
            whoApply.setGoodsApplyId(apply.getId());
            whoApplyMapper.insert(whoApply);
        }

        return true;
    }

    @Override
    public List<PageGoodsApply> getGoodsApplyList(int page, int limit, String  field, String order, String search) {
        GoodsApplyExample example = new GoodsApplyExample();
        GoodsApplyExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsNameLike("%" + search + "%");
        example.setOffset((page-1)*limit);
        example.setLimit(limit);
        example.setOrderByClause(PageGoodsApply.getDbColName(field)+" "+order);
        System.out.println(PageGoodsApply.getDbColName(field)+" "+order);
        List<GoodsApply> applies = goodsApplyMapper.selectByExample(example);
        List<PageGoodsApply> list = new LinkedList<>();
        for(GoodsApply apply : applies){
            PageGoodsApply pApply = changeGoodsApplyToPageGoodsApply(apply);
            list.add(pApply);
        }

        return list;
    }

    private PageGoodsApply changeGoodsApplyToPageGoodsApply(GoodsApply apply){
        PageGoodsApply pApply = new PageGoodsApply();
        pApply.setGoodsId(apply.getId());
        pApply.setGoodsName(apply.getGoodsName());
        pApply.setGoodsKind(getGoodsKindById(apply.getGoodsKind()).getKindName());
        pApply.setGoodsBrand(getGoodsBrandById(apply.getGoodsBrand()).getBrandName());
        pApply.setGoodsModel(apply.getGoodsModel());
        pApply.setGoodsPram(apply.getGoodsParm());
        pApply.setGoodsUnit(getGoodsUnitById(apply.getGoodsUnit()).getUnitName());
        pApply.setGoodsNumber(apply.getGoodsNumber());
        pApply.setGoodsPrice(apply.getGoodsPrice());
        pApply.setWhoUses(getGoodsUserById(apply.getWhoToUse()).getGoodsUserName());
        pApply.setWhatToDo(apply.getWhatToDo());
        pApply.setUrl(apply.getUrl());
        pApply.setNote(apply.getNote());
        pApply.setApplyer(apply.getApplyUser());
        pApply.setApplyDate(apply.getApplyDate());
        pApply.setStatus(apply.getApplyStatus());
        return pApply;
    }

    @Override
    public int getApplyCount() {
        long count = goodsApplyMapper.countByExample(new GoodsApplyExample());
        return (int)count;
    }

    @Override
    public boolean copyApplyToBuy(Integer[] ids) {
        for (int id : ids){
            GoodsApply apply = goodsApplyMapper.selectByPrimaryKey(id);
            GoodsBuy buy = new GoodsBuy();
            buy.setGoodsName(apply.getGoodsName());
            buy.setGoodsBrand(apply.getGoodsBrand());
            buy.setGoodsKind(apply.getGoodsKind());
            buy.setGoodsModel(apply.getGoodsModel());
            buy.setGoodsParm(apply.getGoodsParm());
            buy.setGoodsUnit(apply.getGoodsUnit());
            buy.setGoodsNumber(apply.getGoodsNumber());
            buy.setGoodsPrice(apply.getGoodsPrice());
            buy.setWhoToUse(apply.getWhoToUse());
            buy.setWhatToDo(apply.getWhatToDo());
            buy.setUrl(apply.getUrl());
            buy.setNote(apply.getNote());
            buy.setRealBuyNumber(0);
            buy.setStatus(GOODS_STATUS_BUYING);

            apply.setApplyStatus(GOODS_STATUS_BUYING);//将申请总表里的状态字段设为正在购买

            goodsBuyMapper.insert(buy);
            goodsApplyMapper.updateByPrimaryKeySelective(apply);
        }
        return true;
    }

    @Override
    public boolean copyBuyToPersonalApply(String userid, Integer[] ids) {
        for (int id : ids){
            GoodsBuy buy = goodsBuyMapper.selectByPrimaryKey(id);
            GoodsApplyPersonal personal = new GoodsApplyPersonal();
            personal.setGoodsName(buy.getGoodsName());
            personal.setGoodsBrand(buy.getGoodsBrand());
            personal.setGoodsKind(buy.getGoodsKind());
            personal.setGoodsModel(buy.getGoodsModel());
            personal.setGoodsParm(buy.getGoodsParm());
            personal.setGoodsUnit(buy.getGoodsUnit());
            personal.setGoodsPrice(buy.getGoodsPrice());
            personal.setGoodsNumber(0);
            personal.setGoodsUrl(buy.getUrl());
            personal.setWhoUse(1);
            personal.setWhatToDo("");
            personal.setNote("");
            personal.setApplyUser(userid);

            goodsApplyPersonalMapper.insert(personal);
        }
        return true;
    }

    @Override
    public boolean copyApplyToPersonalApply(String userid, Integer[] ids) {
        for (int id : ids){
            GoodsApply apply = goodsApplyMapper.selectByPrimaryKey(id);
            GoodsApplyPersonal personal = new GoodsApplyPersonal();
            personal.setGoodsName(apply.getGoodsName());
            personal.setGoodsBrand(apply.getGoodsBrand());
            personal.setGoodsKind(apply.getGoodsKind());
            personal.setGoodsModel(apply.getGoodsModel());
            personal.setGoodsParm(apply.getGoodsParm());
            personal.setGoodsUnit(apply.getGoodsUnit());
            personal.setGoodsPrice(apply.getGoodsPrice());
            personal.setGoodsNumber(0);
            personal.setGoodsUrl(apply.getUrl());
            personal.setWhoUse(1);
            personal.setWhatToDo("");
            personal.setNote("");
            personal.setApplyUser(userid);

            goodsApplyPersonalMapper.insert(personal);
        }
        return true;
    }

    @Override
    public boolean deletePersonalApplyById(int id) {
        goodsApplyPersonalMapper.deleteByPrimaryKey(id);
        return true;
    }

    @Override
    public boolean deletePersonalApplyByIds(Integer[] ids) {
        for (int id: ids) {
            goodsApplyPersonalMapper.deleteByPrimaryKey(id);
        }
        return true;
    }

    @Override
    public List<PageGoodsApply> getWhoApplyList(String user, int page, int limit) {
        GoodsWhoApplyExample example = new GoodsWhoApplyExample();
        GoodsWhoApplyExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsApplyerEqualTo(user);
        example.setOffset((page-1)*limit);
        example.setLimit(limit);
        example.setOrderByClause("goods_apply_id desc");
        List<GoodsWhoApply> whoApplies = whoApplyMapper.selectByExample(example);
        List<PageGoodsApply> list = new LinkedList<>();
        for (GoodsWhoApply whoApply : whoApplies){
            int id = whoApply.getGoodsApplyId();
            GoodsApply goodsApply = goodsApplyMapper.selectByPrimaryKey(id);
            PageGoodsApply apply = changeGoodsApplyToPageGoodsApply(goodsApply);
            list.add(apply);
        }
        return list;
    }

    @Override
    public int getWhoApplyCount(String user) {
        GoodsWhoApplyExample example = new GoodsWhoApplyExample();
        GoodsWhoApplyExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsApplyerEqualTo(user);
        long count = whoApplyMapper.countByExample(example);
        return (int)count;
    }

    @Override
    public PageGoodsApplyPersonal getGoodsApplyById(int id) {
        GoodsApplyPersonal apply = goodsApplyPersonalMapper.selectByPrimaryKey(id);
        PageGoodsApplyPersonal pageGoodsApply = changeGoodsApplyPersonalToPageGoodsApplyPersonal(apply);
        return pageGoodsApply;
    }

    @Override
    public PageGoodsApply getApplyMessageById(int id) {
        GoodsApply apply = goodsApplyMapper.selectByPrimaryKey(id);
        PageGoodsApply apply1 = changeGoodsApplyToPageGoodsApply(apply);
        return apply1;
    }

    @Override
    public boolean updatePersonalApply(PageGoodsApplyPersonal personal) {
        GoodsApplyPersonal applyPersonal = changePageApplyPersonToGoodsApplyPerson(personal);
        applyPersonal.setId(personal.getGoodsId());
        System.out.println(applyPersonal);
        int num = goodsApplyPersonalMapper.updateByPrimaryKeySelective(applyPersonal);
        System.out.println(num);
        return true;
    }

    @Override
    public boolean deleteApply(int gid) {
        GoodsApply apply = goodsApplyMapper.selectByPrimaryKey(gid);
        goodsApplyMapper.deleteByPrimaryKey(gid);
        GoodsWhoApplyExample example = new GoodsWhoApplyExample();
        GoodsWhoApplyExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsApplyIdEqualTo(gid);
        whoApplyMapper.deleteByExample(example);
        return true;
    }

    @Override
    public boolean deleteApplyByIds(Integer[] ids) {
        boolean flag = true;
        for (int id : ids){
            flag &= deleteApply(id);
        }
        return flag;
    }

    private GoodsApply changePageGoodsApplyToGoodsApply(PageGoodsApply pageGoodsApply){
        GoodsApply apply = new GoodsApply();
        apply.setId(pageGoodsApply.getGoodsId());
        apply.setGoodsName(pageGoodsApply.getGoodsName());
        apply.setGoodsKind(getGoodsKindByKindName(pageGoodsApply.getGoodsKind()).getKid());
        apply.setGoodsBrand(getGoodsBrandByBrandName(pageGoodsApply.getGoodsBrand()).getBid());
        apply.setGoodsModel(pageGoodsApply.getGoodsModel());
        apply.setGoodsParm(pageGoodsApply.getGoodsPram());
        apply.setGoodsPrice(pageGoodsApply.getGoodsPrice());
        apply.setGoodsUnit(getGoodsUnitByUnitName(pageGoodsApply.getGoodsUnit()).getUnid());
        apply.setGoodsNumber(pageGoodsApply.getGoodsNumber());
        apply.setWhoToUse(getGoodsUserByName(pageGoodsApply.getWhoUses()).getGuid());
        apply.setWhatToDo(pageGoodsApply.getWhatToDo());
        apply.setUrl(pageGoodsApply.getUrl());
        apply.setNote(pageGoodsApply.getNote());
        apply.setApplyUser(pageGoodsApply.getApplyer());
        return apply;
    }

    @Override
    public boolean combineApplys(PageGoodsApply apply, int[] ids) {
        //保存合并后的数据信息
        GoodsApply goodsApply = changePageGoodsApplyToGoodsApply(apply);
        goodsApply.setApplyStatus(GOODS_STATUS_APPLY);
        goodsApplyMapper.updateByPrimaryKeySelective(goodsApply);

        for (int id : ids){
            //修改申请人表对应的申请数据
            GoodsWhoApplyExample example = new GoodsWhoApplyExample();
            GoodsWhoApplyExample.Criteria criteria = example.createCriteria();
            criteria.andGoodsApplyIdEqualTo(id);
            GoodsWhoApply whoApply = new GoodsWhoApply();
            whoApply.setGoodsApplyId(goodsApply.getId());
            whoApplyMapper.updateByExampleSelective(whoApply, example);
            //删除对应的申请
            goodsApplyMapper.deleteByPrimaryKey(id);
        }
        return true;
    }

    @Override
    public boolean addPersonalApplys(List<PageGoodsApplyPersonal>  datas, String user) {
        for (PageGoodsApplyPersonal personal : datas){
            GoodsApplyPersonal goodsApplyPersonal = changePageApplyPersonToGoodsApplyPerson(personal);
            goodsApplyPersonal.setApplyCount(0);
            goodsApplyPersonal.setApplyUser(user);
            goodsApplyPersonalMapper.insert(goodsApplyPersonal);
        }

        return true;
    }

    @Override
    public boolean editApply(PageGoodsApply pageGoodsApply) {
        System.out.println(pageGoodsApply);
        GoodsApply apply = changePageGoodsApplyToGoodsApply(pageGoodsApply);
        apply.setId(pageGoodsApply.getGoodsId());
        goodsApplyMapper.updateByPrimaryKeySelective(apply);
        return true;
    }

    public Company getCompanyByName(String name, String user, String phone){
        CompanyExample example = new CompanyExample();
        CompanyExample.Criteria criteria = example.createCriteria();
        criteria.andCompanyNameEqualTo(name);
        List<Company> list = companyMapper.selectByExample(example);
        Company company;
        if (list != null && list.size() > 0){
            company = list.get(0);
        }else {
            company = new Company();
            company.setCompanyName(name);
            companyMapper.insert(company);
        }
        company.setCompanyName(name);
        company.setUserName(user);
        company.setUserPhone(phone);
        companyMapper.updateByPrimaryKeySelective(company);
        return company;
    }

    public BuyList changePageBuyListItemToBuyList(PageBuyListItem item) throws ParseException {
        BuyList buy = new BuyList();
        buy.setGoodsName(item.getGoodsName());
        buy.setGoodsKind(getGoodsKindByKindName(item.getGoodsKind()).getKid());
        buy.setGoodsBrand(getGoodsBrandByBrandName(item.getGoodsBrand()).getBid());
        buy.setGoodsModel(item.getGoodsModel());
        buy.setGoodsParm(item.getGoodsParm());
        buy.setGoodsPrice(item.getGoodsPrice());
        buy.setGoodsUnit(getGoodsUnitByUnitName(item.getGoodsUnit()).getUnid());
        buy.setGoodsNumber(item.getGoodsNumber());
        buy.setCompleteStatus(GOODS_STATUS_NO_BUY);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(item.getWillCompliteDate());
        buy.setWillCompleteDate(date);
        Company company = getCompanyByName(item.getComplanyName(), item.getcUser(),item.getPhone());
        buy.setBuyCompany(company.getId());
        buy.setUser(item.getcUser());
        buy.setPhone(item.getPhone());
        return buy;
    }

    @Override
    public boolean toBuyGoods(List<PageBuyListItem> list) throws ParseException {
        Date date = new Date();
        for (PageBuyListItem item : list){
            System.out.println(item);
            //插入采购清单表
            BuyList buy = changePageBuyListItemToBuyList(item);
            buy.setPid(date);
            buyListMapper.insert(buy);
            //修改申请总表状态
            int goodsId = item.getGoodsId();
            GoodsApply apply = goodsApplyMapper.selectByPrimaryKey(goodsId);
            apply.setApplyStatus(GOODS_STATUS_NO_BUY);
            goodsApplyMapper.updateByPrimaryKeySelective(apply);
            //记录采购清单和申请总表的关系
            ApplyBuylist applyBuylist = new ApplyBuylist();
            applyBuylist.setApplyid(goodsId);
            applyBuylist.setBuylistid(buy.getId());
            applyBuylistMapper.insert(applyBuylist);
        }
        return true;
    }
}
