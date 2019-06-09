package goods.service.impl;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import goods.mapper.GoodsBorrowMapper;
import goods.mapper.GoodsStoreMapper;
import goods.mapper.UserMapper;
import goods.pojo.*;
import goods.service.GoodsApplyService;
import goods.service.GoodsStoreService;
import goods.vo.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 王业权
 * @功能
 * @time 2019/3/14 11:21
 */
@Transactional
@Service("goodsStoreService")
public class GoodsStoreServiceImpl implements GoodsStoreService {
    Logger log = Logger.getLogger(GoodsStoreMapper.class);

    //物品借出状态
    private static String BORROW_STATUS_BORROWING = "已借出";
    private static String BORROW_STATUS_RETURN = "已归还";
    private static String BORROW_STATUS_SOME_RETURN = "部分归还";
    private static String GIVE_STATUS_GIVED = "已领取";


    @Autowired
    GoodsStoreMapper storeMapper;
    @Autowired
    GoodsApplyService goodsApplyService;
    @Autowired
    GoodsBorrowMapper goodsBorrowMapper;
    @Autowired
    UserMapper userMapper;

    /**
     * 将数据库对象转变成页面对象
     * @param store
     * @return
     */
    private PageGoodsStore changeGoodsStoreToPageGoodsStore(GoodsStore store){
        GoodsApplyServiceImpl applyService = (GoodsApplyServiceImpl)goodsApplyService;
        PageGoodsStore pStore = new PageGoodsStore();
        pStore.setGoodsId(store.getId());
        pStore.setGoodsName(store.getGoodsName());
        pStore.setGoodsKind(applyService.getGoodsKindById(store.getGoodsKind()).getKindName());
        pStore.setGoodsBrand(applyService.getGoodsBrandById(store.getGoodsBrand()).getBrandName());
        pStore.setGoodsModel(store.getGoodsModel());
        pStore.setGoodsPram(store.getGoodsParm());
        pStore.setGoodsUnit(applyService.getGoodsUnitById(store.getGoodsUnit()).getUnitName());
        pStore.setGoodsNumber(store.getGoodsNumber());
        pStore.setBorrowNumber(store.getGoodsBorrowNumber());
        pStore.setGiveNumber(store.getGoodsGiveNumber());
        pStore.setNote(store.getNote());
        return  pStore;
    }

    /**
     * 将页面库存对象转变成数据库存储对象
     * @param pageGoodsStore
     * @return
     */
    public GoodsStore changePageGoodsStoreToGoodsStore(PageGoodsStore pageGoodsStore){
        GoodsApplyServiceImpl applyService = (GoodsApplyServiceImpl)goodsApplyService;
        GoodsStore store = new GoodsStore();
        store.setId(pageGoodsStore.getGoodsId());
        store.setGoodsName(pageGoodsStore.getGoodsName());
        store.setGoodsKind(applyService.getGoodsKindByKindName(pageGoodsStore.getGoodsKind()).getKid());
        store.setGoodsBrand(applyService.getGoodsBrandByBrandName(pageGoodsStore.getGoodsBrand()).getBid());
        store.setGoodsModel(pageGoodsStore.getGoodsModel());
        store.setGoodsParm(pageGoodsStore.getGoodsPram());
        store.setGoodsUnit(applyService.getGoodsUnitByUnitName(pageGoodsStore.getGoodsUnit()).getUnid());
        store.setGoodsNumber(pageGoodsStore.getGoodsNumber());
        Integer giveNum = pageGoodsStore.getGiveNumber();
        Integer borrowNum = pageGoodsStore.getBorrowNumber();
        store.setGoodsGiveNumber(giveNum == null ? 0 : giveNum);
        store.setGoodsBorrowNumber(borrowNum == null ? 0 : borrowNum);
        store.setNote(pageGoodsStore.getNote());
        return store;
    }

    @Override
    public List<PageGoodsStore> getStoreList(int page, int limit, String fied, String order, String search) {
        GoodsStoreExample example = new GoodsStoreExample();
        GoodsStoreExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsNameLike("%" + search + "%");
        example.setOffset((page-1)*limit);
        example.setLimit(limit);
        example.setOrderByClause(PageGoodsStore.getDbColName(fied)+" " + order);
        List<GoodsStore> goodsStores = storeMapper.selectByExample(example);
        List<PageGoodsStore> list = new LinkedList<>();
        for (GoodsStore store : goodsStores){
            PageGoodsStore pageGoodsStore = changeGoodsStoreToPageGoodsStore(store);
            list.add(pageGoodsStore);
        }
        return list;
    }

    @Override
    public int getStoreCount() {
        long count = storeMapper.countByExample(new GoodsStoreExample());
        return (int)count;
    }

    public User getUserByUserName(String username){
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(username);
        List<User> list = userMapper.selectByExample(example);
        if(list != null && list.size() == 1){
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean addUserBorrowGoods(String user, int gsid, int gnumber,String gusername,String date) throws ParseException {
        User u = getUserByUserName(user);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = format.parse(date);
        GoodsBorrow borrow = new GoodsBorrow();
        borrow.setGoodsId(gsid);
        borrow.setUserId(u == null ? user : u.getUserId());
        borrow.setNumber(gnumber);
        borrow.setBorrowDate(new Date());
        borrow.setWillReturnDate(date1);
        borrow.setBorrowUserId(gusername);
        borrow.setStatus(BORROW_STATUS_BORROWING);
        borrow.setIsBorrow(true);
        goodsBorrowMapper.insert(borrow);
        GoodsStore store = storeMapper.selectByPrimaryKey(gsid);
        store.setGoodsNumber(store.getGoodsNumber()-gnumber);
        store.setGoodsBorrowNumber(store.getGoodsBorrowNumber()+gnumber);
        storeMapper.updateByPrimaryKeySelective(store);
        return true;
    }

    @Override
    public boolean addUserGiveGoods(String user, int gsid, int gnumber, String gusername) {
        User u = getUserByUserName(user);
        GoodsBorrow borrow = new GoodsBorrow();
        borrow.setGoodsId(gsid);
        borrow.setUserId(u == null ? user : u.getUserId());
        borrow.setNumber(gnumber);
        borrow.setBorrowDate(new Date());
        borrow.setBorrowUserId(gusername);
        borrow.setStatus(GIVE_STATUS_GIVED);
        borrow.setIsBorrow(false);
        goodsBorrowMapper.insert(borrow);
        GoodsStore store = storeMapper.selectByPrimaryKey(gsid);
        store.setGoodsNumber(store.getGoodsNumber()-gnumber);
        store.setGoodsGiveNumber(store.getGoodsGiveNumber()+gnumber);
        storeMapper.updateByPrimaryKeySelective(store);
        return true;
    }

    /**
     * 根据id获取物品库存信息
     * @param gid
     * @return
     */
    public GoodsStore getGoodsStoreById(int gid){
        return storeMapper.selectByPrimaryKey(gid);
    }

    @Override
    public List<PageGoodsGiveOrBorrow> getUserGiveOrBorrowList(String user, int page, int limit, String field, String order, String kinds) {
        GoodsBorrowExample example = new GoodsBorrowExample();
        GoodsBorrowExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(user);
        if(kinds.equals("") || kinds.equals("showBorrowing")) {
            criteria.andIsBorrowEqualTo(true);
            criteria.andStatusNotEqualTo(BORROW_STATUS_RETURN);
        }else if(kinds.equals("showBorrow")){
            criteria.andIsBorrowEqualTo(true);
        }else if(kinds.equals("showGive")){
            criteria.andIsBorrowEqualTo(false);
        }
        example.setOffset((page-1)*limit);
        example.setLimit(limit);
        example.setOrderByClause(PageGoodsGiveOrBorrow.getDbColName(field)+" "+order);
        List<GoodsBorrow> borrows = goodsBorrowMapper.selectByExample(example);
        List<PageGoodsGiveOrBorrow> borrowss = new LinkedList<>();
        for (GoodsBorrow borrow : borrows){
            int gid = borrow.getGoodsId();
            GoodsStore goodsStore = getGoodsStoreById(gid);
            PageGoodsStore store = changeGoodsStoreToPageGoodsStore(goodsStore);
            PageGoodsGiveOrBorrow giveOrBorrow = new PageGoodsGiveOrBorrow(store);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String dateStr = format.format(borrow.getBorrowDate());
            giveOrBorrow.setBorrowTime(dateStr);
            giveOrBorrow.setNumber(borrow.getNumber());
            giveOrBorrow.setStatus(borrow.getStatus());
            giveOrBorrow.setUsername(getUserByUserId(borrow.getUserId()).getUserName());
            giveOrBorrow.setReNumber(borrow.getReturnNumber()==null ? 0 : borrow.getReturnNumber());
            borrowss.add(giveOrBorrow);
        }
        return borrowss;
    }

    @Override
    public int getUserGiveOrBorrowCount(String user, String kinds) {
        GoodsBorrowExample example = new GoodsBorrowExample();
        GoodsBorrowExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(user);
        if(kinds.equals("") || kinds.equals("showBorrowing")) {
            criteria.andIsBorrowEqualTo(true);
            criteria.andStatusEqualTo(BORROW_STATUS_BORROWING);
        }else if(kinds.equals("showBorrow")){
            criteria.andIsBorrowEqualTo(true);
        }else if(kinds.equals("showGive")){
            criteria.andIsBorrowEqualTo(false);
        }
        long count = goodsBorrowMapper.countByExample(example);
        return 0;
    }

    @Override
    public boolean addStore(PageGoodsStore goodsStore) {
        GoodsStore store = changePageGoodsStoreToGoodsStore(goodsStore);
        store.setGoodsBorrowNumber(0);
        store.setGoodsBorrowNumber(0);
        storeMapper.insert(store);
        return true;
    }

    @Override
    public boolean deleteStore(int id) {
        return storeMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean updateGoodsStore(PageGoodsStore store) {
        GoodsStore goodsStore = changePageGoodsStoreToGoodsStore(store);
//        storeMapper.updateByPrimaryKey(goodsStore);
        storeMapper.updateByPrimaryKeySelective(goodsStore);
        return true;
    }

    /**
     * 根据用户id获取用户对象
     * @param userid
     * @return
     */
    public User getUserByUserId(String userid){
        return userMapper.selectByPrimaryKey(userid);
    }

    /**
     * 将数据库对象转变为页面对象
     * @return
     */
    public PageGoodsGiveOrBorrow changeGoodsBorrowToPageGoodsGiveOrBorrow(PageGoodsStore store, GoodsBorrow borrow){
        PageGoodsGiveOrBorrow giveOrBorrow = new PageGoodsGiveOrBorrow(store);
        giveOrBorrow.setGbid(borrow.getGbid());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateStr = format.format(borrow.getBorrowDate());
        giveOrBorrow.setBorrowTime(dateStr);
        giveOrBorrow.setNumber(borrow.getNumber());
        giveOrBorrow.setStatus(borrow.getStatus());
        User user = getUserByUserId(borrow.getUserId());
        giveOrBorrow.setUsername(user == null ? borrow.getUserId(): user.getUserName());
        giveOrBorrow.setBusername(borrow.getBorrowUserId());
        Date wdate = borrow.getWillReturnDate();
        giveOrBorrow.setWillReturnDate(wdate == null ? "" : format.format(wdate));
        giveOrBorrow.setNote(borrow.getNote());
        giveOrBorrow.setReNumber(borrow.getReturnNumber() == null ? 0 : borrow.getReturnNumber());
        giveOrBorrow.setReusername(borrow.getReturnUserId());
        Date rdate = borrow.getReturnDate();
        giveOrBorrow.setReDate(rdate == null ? "" : format.format(rdate));

        return giveOrBorrow;
    }

    @Override
    public List<PageGoodsGiveOrBorrow> getGoodsBorrowOrGiveList(boolean isBorrow, int page, int limit, String field, String order, String search) {
        GoodsApplyServiceImpl applyService = (GoodsApplyServiceImpl)goodsApplyService;
        GoodsBorrowExample example = new GoodsBorrowExample();
        GoodsBorrowExample.Criteria criteria = example.createCriteria();
        criteria.andIsBorrowEqualTo(isBorrow);
        criteria.andUserIdLike("%"+search+"%");
        criteria.andStatusNotEqualTo(BORROW_STATUS_RETURN);
        example.setOffset((page-1)*limit);
        example.setLimit(limit);
        example.setOrderByClause(PageGoodsGiveOrBorrow.getDbColName(field)+" "+order);
        List<GoodsBorrow> borrows = goodsBorrowMapper.selectByExample(example);
        List<PageGoodsGiveOrBorrow> borrowss = new LinkedList<>();
        for (GoodsBorrow borrow : borrows){
            int gid = borrow.getGoodsId();
            GoodsStore goodsStore = getGoodsStoreById(gid);
            PageGoodsStore store = changeGoodsStoreToPageGoodsStore(goodsStore);
            PageGoodsGiveOrBorrow giveOrBorrow = changeGoodsBorrowToPageGoodsGiveOrBorrow(store, borrow);

            borrowss.add(giveOrBorrow);
        }
        return borrowss;
    }

    @Override
    public List<PageGoodsGiveOrBorrow> getAllGoodsBorrowOrGiveList(int page, int limit, String field, String order, String search, String kind) {
        GoodsApplyServiceImpl applyService = (GoodsApplyServiceImpl)goodsApplyService;
        GoodsBorrowExample example = new GoodsBorrowExample();
        GoodsBorrowExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdLike("%"+search+"%");
        if (kind.equals("showBorrow")){
            criteria.andIsBorrowEqualTo(true);
        }else if(kind.equals("showGive")){
            criteria.andIsBorrowEqualTo(false);
        }
        example.setOffset((page-1)*limit);
        example.setLimit(limit);
        example.setOrderByClause(PageGoodsGiveOrBorrow.getDbColName(field)+" "+order);
        List<GoodsBorrow> borrows = goodsBorrowMapper.selectByExample(example);
        List<PageGoodsGiveOrBorrow> borrowss = new LinkedList<>();
        for (GoodsBorrow borrow : borrows){
            int gid = borrow.getGoodsId();
            GoodsStore goodsStore = getGoodsStoreById(gid);
            PageGoodsStore store = changeGoodsStoreToPageGoodsStore(goodsStore);
            PageGoodsGiveOrBorrow giveOrBorrow = changeGoodsBorrowToPageGoodsGiveOrBorrow(store, borrow);
            borrowss.add(giveOrBorrow);
        }
        return borrowss;
    }

    @Override
    public int getBorrowOrGiveCount(boolean isBorrow) {
        GoodsBorrowExample example = new GoodsBorrowExample();
        GoodsBorrowExample.Criteria criteria = example.createCriteria();
        criteria.andIsBorrowEqualTo(isBorrow);
        long count = goodsBorrowMapper.countByExample(example);
        return 0;
    }

   /* @Override
    public boolean passBorrowOrGive(int gbid) {
        GoodsBorrow borrow = new GoodsBorrow();
        borrow.setGbid(gbid);
        borrow.setStatus(BORROW_STATUS_PASS);
        goodsBorrowMapper.updateByPrimaryKeySelective(borrow);
        return true;
    }*/

    /*@Override
    public boolean cancelPassBorrowOrGive(int gbid) {
        GoodsBorrow borrow = new GoodsBorrow();
        borrow.setGbid(gbid);
        borrow.setStatus(BORROW_STATUS_APPLY);
        goodsBorrowMapper.updateByPrimaryKeySelective(borrow);
        return true;
    }*/

    @Override
    public boolean outBorrowOrGive(int gbid) {
        GoodsBorrow borrow = goodsBorrowMapper.selectByPrimaryKey(gbid);
        int goodId = borrow.getGoodsId();
        GoodsStore store = storeMapper.selectByPrimaryKey(goodId);
        if (store.getGoodsNumber() >= borrow.getNumber()){
            borrow.setStatus(borrow.getIsBorrow() ? BORROW_STATUS_BORROWING : GIVE_STATUS_GIVED);
            goodsBorrowMapper.updateByPrimaryKeySelective(borrow);
            if (borrow.getIsBorrow()) {
                store.setGoodsBorrowNumber(store.getGoodsBorrowNumber() + borrow.getNumber());
            }else {
                store.setGoodsGiveNumber(store.getGoodsGiveNumber() + borrow.getNumber());
            }
            store.setGoodsNumber(store.getGoodsNumber() - borrow.getNumber());
            storeMapper.updateByPrimaryKeySelective(store);
            return true;
        }
        return false;
    }

    @Override
    public boolean returnBorrow(int gbid) {
        GoodsBorrow borrow = goodsBorrowMapper.selectByPrimaryKey(gbid);
        if (BORROW_STATUS_BORROWING.equals(borrow.getStatus())){
            borrow.setStatus(BORROW_STATUS_RETURN);
            goodsBorrowMapper.updateByPrimaryKeySelective(borrow);
            int goodId = borrow.getGoodsId();
            GoodsStore store = storeMapper.selectByPrimaryKey(goodId);
            store.setGoodsNumber(store.getGoodsNumber() + borrow.getNumber());
            storeMapper.updateByPrimaryKeySelective(store);
            return true;
        }
        return false;
    }

    @Override
    public boolean scrapGoods(int gsid, int gnumber) {
        GoodsStore store = storeMapper.selectByPrimaryKey(gsid);
        store.setGoodsNumber(store.getGoodsNumber() - gnumber);
        storeMapper.updateByPrimaryKeySelective(store);
        return true;
    }

    /**
     * 将页面借领对象转变成
     * @param borrowGive
     * @return
     */
    public GoodsBorrow changePageGoodsBorrowGiveToGoodsBorrow(PageGoodsBorrowGive borrowGive) throws ParseException {
        User user = getUserByUserName(borrowGive.getUsername());
        Date date = null;
        if(!"".equals(borrowGive.getWillReturnDate())){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            date = format.parse(borrowGive.getWillReturnDate());
        }
        GoodsBorrow borrow = new GoodsBorrow();

        borrow.setGoodsId(borrowGive.getGoodId());
        borrow.setUserId(user == null ? borrowGive.getUsername() : user.getUserId());
        borrow.setBorrowUserId(borrowGive.getPusername());
        borrow.setNumber(borrowGive.getNumber());
        borrow.setIsBorrow(Boolean.parseBoolean(borrowGive.getIsBorrow()));
        borrow.setBorrowDate(new Date());
        borrow.setWillReturnDate(date);
        borrow.setNote(borrowGive.getNote());
        borrow.setStatus(borrow.getIsBorrow() ? BORROW_STATUS_BORROWING : GIVE_STATUS_GIVED);
        return borrow;
    }

    @Override
    public boolean borrowOrGive(List<PageGoodsBorrowGive> list) throws ParseException {
        System.out.println(list);
        for (PageGoodsBorrowGive bg : list){
            GoodsBorrow borrow = changePageGoodsBorrowGiveToGoodsBorrow(bg);
            System.out.println(borrow);
            goodsBorrowMapper.insert(borrow);
            GoodsStore store = storeMapper.selectByPrimaryKey(borrow.getGoodsId());
            store.setGoodsNumber(store.getGoodsNumber() - borrow.getNumber());
            if (borrow.getIsBorrow()){
                store.setGoodsBorrowNumber(store.getGoodsBorrowNumber()+borrow.getNumber());
            }else {
                store.setGoodsGiveNumber(store.getGoodsGiveNumber() + borrow.getNumber());
            }
            storeMapper.updateByPrimaryKeySelective(store);
        }

        return true;
    }

    @Override
    public boolean scrapGoods(List<PageGoodsScrap> list) {
        for (PageGoodsScrap scrap : list){
            int gsid = scrap.getGoodsId();
            int gnumber = scrap.getScrapNumber();
            GoodsStore store = storeMapper.selectByPrimaryKey(gsid);
            store.setGoodsNumber(store.getGoodsNumber() - gnumber);
            storeMapper.updateByPrimaryKeySelective(store);
        }
        return true;
    }

    @Override
    public boolean returnBorrow(int gbid, int returnNumber, String returnUser, String note) {
        GoodsBorrow borrow = goodsBorrowMapper.selectByPrimaryKey(gbid);
        borrow.setReturnDate(new Date());
        Integer rnum = borrow.getReturnNumber();
        borrow.setReturnNumber(rnum == null ? returnNumber : rnum + returnNumber);
        borrow.setReturnUserId(returnUser);
        borrow.setNote(borrow.getNote() + ";" + note);
        if(borrow.getNumber() == borrow.getReturnNumber()){
            borrow.setStatus(BORROW_STATUS_RETURN);
        }else {
            borrow.setStatus(BORROW_STATUS_SOME_RETURN);
        }
        goodsBorrowMapper.updateByPrimaryKeySelective(borrow);
        int goodsId = borrow.getGoodsId();
        GoodsStore store = storeMapper.selectByPrimaryKey(goodsId);
        store.setGoodsBorrowNumber(store.getGoodsBorrowNumber()-returnNumber);
        store.setGoodsNumber(store.getGoodsNumber() + returnNumber);
        storeMapper.updateByPrimaryKeySelective(store);
        return true;
    }

    /**
     * 将模型对象转变成数据库对象，方便插入
     * @param model
     * @return
     */
    private GoodsStore changeExportToDb(ExportModelFile model){
        if(null == model){
            return null;
        }
        GoodsApplyServiceImpl applyService = (GoodsApplyServiceImpl)goodsApplyService;
        GoodsStore store = new GoodsStore();
        store.setGoodsName(model.getName());
        store.setGoodsModel(model.getModel());
        store.setGoodsKind(applyService.getGoodsKindByKindName(model.getKind()).getKid());
        store.setGoodsBrand(applyService.getGoodsBrandByBrandName(model.getBrand()).getBid());
        store.setGoodsUnit(applyService.getGoodsUnitByUnitName(model.getUnit()).getUnid());
        store.setGoodsNumber(Integer.parseInt(model.getNumber()));
        store.setGoodsGiveNumber(0);
        store.setGoodsBorrowNumber(0);
        return store;
    }

    @Override
    @Transactional
    public void pauseExportModelFile(InputStream is, String filename) {
        try{
            ExcelReader excelReader = null;
            ExcelReaderListener listener = new ExcelReaderListener();
            if(filename.endsWith(".xlsx")){
                excelReader = new ExcelReader(is, ExcelTypeEnum.XLSX, null,listener);
            }else if(filename.endsWith(".xls")){
                excelReader = new ExcelReader(is, ExcelTypeEnum.XLS, null,listener);
            }else{
                throw new RuntimeException("文件不支持");
            }
            excelReader.read(new Sheet(1,1),ExportModelFile.class);
            List<ExportModelFile> list = listener.getList();
            log.info("列表长度：" + list.size());
            for(ExportModelFile model : list){
                GoodsStore store = changeExportToDb(model);
                storeMapper.insert(store);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
