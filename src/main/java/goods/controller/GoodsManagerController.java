package goods.controller;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import goods.mapper.UserMapper;
import goods.pojo.Company;
import goods.service.*;
import goods.vo.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.ParseException;
import java.util.List;

/**
 * @author 王业权
 * @功能 物管员操作
 * @time 2019/3/12 10:41
 */
@Controller
@RequestMapping("gmanager")
public class GoodsManagerController {
    private static Logger logger = Logger.getLogger(GoodsManagerController.class);

    @Autowired
    GoodsApplyService applyService;
    @Autowired
    GoodsBuyService buyService;
    @Autowired
    GoodsStoreService storeService;
    @Autowired
    UserService userService;
    @Autowired
    InitService initService;

    /**
     * 将申请总表的内容提交到采购总表里去
     * @param ids
     * @return
     */
    @RequestMapping("/addApplyToBuy")
    @ResponseBody
    public boolean addApplyToBuy(@RequestParam(value = "ids[]") Integer[] ids){
        System.out.println(ids);
        boolean flag = false;
        try {
            flag = applyService.copyApplyToBuy(ids);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return true;
    }

    /**
     * 获取采购总表
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("getGoodsBuyList")
    @ResponseBody
    public PageListBuy getGoodsBuyList(@RequestParam(defaultValue = "1") int page,
                                       @RequestParam(defaultValue = "15") int limit,
                                       @RequestParam(defaultValue = "goodsId") String field,
                                       @RequestParam(defaultValue = "desc") String order,
                                       @RequestParam(defaultValue = "") String search){
        PageListBuy pageList = new PageListBuy();
        List<PageGoodsBuy> list = buyService.getGoodsBuyList(page, limit, field, order, search);
        int count = buyService.getBuyCount();
        pageList.setCount(count);
        pageList.setData(list);
        return pageList;
    }

    /**
     * 将选中项添加到库存
     * @param ids
     * @return
     */
    @RequestMapping("/addBuysToStore")
    @ResponseBody
    public boolean addBuysToStore(@RequestParam(value = "ids[]") Integer[] ids){
        System.out.println(ids);
        boolean flag = false;
        try {
            flag = buyService.copyBuyToStore(ids);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return true;
    }

    /**
     * 合并申请物品
     * @param apply //合并后保存合并内容的申请
     * @param ecids //待删除的申请的id
     * @return
     */
    @RequestMapping("combineApply")
    @ResponseBody
    public boolean combineApply(PageGoodsApply apply, @RequestParam(value = "ecids") String ecids){
        boolean flag = false;
        try {
            String[] sids = ecids.split(",");
            int[] ids = new int[sids.length];
            System.out.print("ids[");
            for (int i = 0; i < sids.length; i++){
                int id = Integer.parseInt(sids[i]);
                ids[i] = id;
                System.out.print(id + ",");
            }
            System.out.println("]");
            System.out.println(apply);
            flag = applyService.combineApplys(apply, ids);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return flag;
    }

    /**
     * 添加库存
     * @param goodsStore
     * @return
     */
    @ResponseBody
    @RequestMapping("addStore")
    public boolean addStore(PageGoodsStore goodsStore){
        boolean flag = false;
        try {
            flag = storeService.addStore(goodsStore);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(),e);
        }
        return flag;
    }

    /**
     * 删除库存
     * @param gid
     * @return
     */
    @ResponseBody
    @RequestMapping("deleteStore")
    public boolean deleteStore(@RequestParam int gid){
        boolean flag = false;
        try {
            flag = storeService.deleteStore(gid);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(),e);
        }
        return flag;
    }

    @ResponseBody
    @RequestMapping("editStore")
    public boolean editStore(PageGoodsStore store){
        boolean flag = false;
        try {
            flag = storeService.updateGoodsStore(store);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(),e);
        }
        return flag;
    }

    /**
     * 查看所有借出列表
     * @param page
     * @param limit
     * @param field
     * @param order
     * @return
     */
    @RequestMapping("getGoodsBorrowList")
    @ResponseBody
    public PageListGiveOrBorrow getGoodsBorrowList(@RequestParam(defaultValue = "1") int page,
                                                    @RequestParam(defaultValue = "10") int limit,
                                                    @RequestParam(defaultValue = "borrow_date") String field,
                                                    @RequestParam(defaultValue = "desc") String order,
                                                    @RequestParam(defaultValue = "") String search){
        PageListGiveOrBorrow pageList = new PageListGiveOrBorrow();
        List<PageGoodsGiveOrBorrow> list = storeService.getGoodsBorrowOrGiveList(true, page, limit, field, order, search);
        int count = storeService.getBorrowOrGiveCount(true);
        pageList.setCount(count);
        pageList.setData(list);
        return pageList;
    }

    @RequestMapping("getAllGoodsBorrowList")
    @ResponseBody
    public PageListGiveOrBorrow getAllGoodsBorrowList(@RequestParam(defaultValue = "1") int page,
                                         @RequestParam(defaultValue = "10") int limit,
                                         @RequestParam(defaultValue = "goodsId") String field,
                                         @RequestParam(defaultValue = "desc") String order,
                                         @RequestParam(defaultValue = "") String search,
                                         @RequestParam(defaultValue = "showAllHistory") String kind){
        PageListGiveOrBorrow pageList = new PageListGiveOrBorrow();
        List<PageGoodsGiveOrBorrow> list = storeService.getAllGoodsBorrowOrGiveList(page, limit, field, order, search, kind);
        int count = storeService.getBorrowOrGiveCount(true);
        pageList.setCount(count);
        pageList.setData(list);
        return pageList;
    }

    /**
     * 查看所有领取列表
     * @param page
     * @param limit
     * @param field
     * @param order
     * @return
     */
    @ResponseBody
    @RequestMapping("getGoodsGiveList")
    public PageListGiveOrBorrow getGoodsGiveList(@RequestParam(defaultValue = "1") int page,
                                                 @RequestParam(defaultValue = "10") int limit,
                                                 @RequestParam(defaultValue = "goodsId") String field,
                                                 @RequestParam(defaultValue = "desc") String order,
                                                 @RequestParam(defaultValue = "") String search){
        PageListGiveOrBorrow pageList = new PageListGiveOrBorrow();
        List<PageGoodsGiveOrBorrow> list = storeService.getGoodsBorrowOrGiveList(false, page, limit, field, order, search);
        int count = storeService.getBorrowOrGiveCount(false);
        pageList.setCount(count);
        pageList.setData(list);
        return pageList;
    }

    @RequestMapping("outBorrowOrGiveApply")
    @ResponseBody
    public boolean outBorrowOrGiveApply(int gbid){
        boolean flag = false;
        try {
            flag = storeService.outBorrowOrGive(gbid);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return flag;
    }

    @ResponseBody
    @RequestMapping("backBorrow")
    public boolean backBorrow(int gbid){
        boolean flag = false;
        try {
            flag = storeService.returnBorrow(gbid);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return flag;
    }

    /**
     * 归还物品
     * @return
     */
    @ResponseBody
    @RequestMapping("returnBorrow")
    public boolean returnBorrow(int gbid, int returnNumber, String returnUser, String note){
        boolean flag = false;
        try {
            flag = storeService.returnBorrow(gbid, returnNumber, returnUser, note);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return flag;

    }

    @ResponseBody
    @RequestMapping("borrowsOrGives")
    public boolean borrowsOrGives(@RequestBody List<PageGoodsBorrowGive> list){
        boolean flag = false;
        try {
            flag = storeService.borrowOrGive(list);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return flag;
    }

    @RequestMapping("scrapGoods")
    @ResponseBody
    public boolean scrapGoods(@RequestBody List<PageGoodsScrap> list){
        boolean flag = false;
        try {
            flag = storeService.scrapGoods(list);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return flag;
    }

    @RequestMapping("editApply")
    @ResponseBody
    public boolean editApply(PageGoodsApply pageGoodsApply){
        boolean flag = false;
        try {
            flag = applyService.editApply(pageGoodsApply);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return flag;
    }

    @ResponseBody
    @RequestMapping("deleteApply")
    public boolean deleteApply(@RequestParam(value = "ids[]") Integer[] ids){
        boolean flag = false;
        try {
            flag = applyService.deleteApplyByIds(ids);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return flag;
    }

    /**
     * 添加进采购清单
     * @return
     */
    @RequestMapping("addBuyList")
    @ResponseBody
    public boolean addBuyList(@RequestBody List<PageBuyListItem> list){
        boolean flag = false;
        try {
            flag = applyService.toBuyGoods(list);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return flag;
    }

    /**
     * 获取清单列表
     * @return
     */
    @ResponseBody
    @RequestMapping("getBuyList")
    public PageListBuyList getBuyList(@RequestParam(defaultValue = "1") int page,
                                      @RequestParam(defaultValue = "10") int limit,
                                      @RequestParam(defaultValue = "pid") String field,
                                      @RequestParam(defaultValue = "desc") String order,
                                      @RequestParam(defaultValue = "") String search){
        PageListBuyList pageList = new PageListBuyList();
        List<PageBuyLists> list = buyService.getBuyListItemList(page, limit, field, order, search);
        int count = buyService.getBuyListItemCount();
        pageList.setCount(count);
        pageList.setData(list);
        return pageList;
    }

    @RequestMapping("getBuyListByPid")
    @ResponseBody
    public PageListBuyListItem getBuyListByPid(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit, String pid) throws ParseException {
        PageListBuyListItem pageList = new PageListBuyListItem();
        List<PageBuyListItem> list = buyService.listBuyListItem(page, limit, pid);
        int count = buyService.getBuyListCount(pid);
        pageList.setCount(count);
        pageList.setData(list);
        return pageList;
    }

    @RequestMapping("/fileDownLoad")
    public ResponseEntity<byte[]> fileDownLoad(HttpServletRequest request, String pid) throws Exception{

        List<PageBuyListItem> list = buyService.listBuyListItem(pid);
        OutputStream os = buyService.sureBuyList(pid);


        String fileName=new String(("低耗品采购清单_"+pid+".xlsx").getBytes("gbk"),"iso8859-1");//防止中文乱码
        HttpHeaders headers=new HttpHeaders();//设置响应头
        headers.add("Content-Disposition", "attachment;filename="+fileName);
        HttpStatus statusCode = HttpStatus.OK;//设置响应吗
        ResponseEntity<byte[]> response=new ResponseEntity<byte[]>(((ByteArrayOutputStream) os).toByteArray(), headers, statusCode);
        return response;
    }

    /**
     * 物品入库
     * @return
     */
    @ResponseBody
    @RequestMapping("insertStore")
    public boolean insertStore(PageGoodsStore store){
        boolean flag = false;
        try {
            flag = buyService.insertIntoStore(store);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return flag;
    }

    @ResponseBody
    @RequestMapping("getUserList")
    public PageListUserShow getUserList(@RequestParam(defaultValue = "1") int page,
                            @RequestParam(defaultValue = "10") int limit,
                            @RequestParam(defaultValue = "user_id") String field,
                            @RequestParam(defaultValue = "desc") String order){
        PageListUserShow pageList = new PageListUserShow();
        List<PageUserShow> list = userService.getUserList(page, limit, field, order);
        int count = userService.getUserCount();
        pageList.setCount(count);
        pageList.setData(list);
        return pageList;
    }

    @RequestMapping("addUser")
    @ResponseBody
    public boolean addUser(PageUserShow show){
        boolean flag = false;
        try {
            flag = userService.insertIntoUser(show);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return flag;
    }

    @ResponseBody
    @RequestMapping("deleteUser")
    public boolean deleteUser(String id){
        boolean flag = false;
        try {
            if("admin".equalsIgnoreCase(id)){
                throw new RuntimeException("管理员不可删除");
            }
            flag = userService.deleteUser(id);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return flag;
    }

    @RequestMapping("editUser")
    @ResponseBody
    public boolean editUser(PageUserShow show){
        boolean flag = false;
        try {
            flag = userService.editUser(show);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return flag;
    }

    @ResponseBody
    @RequestMapping("getCompanyList")
    public PageListCompany getCompanyList(@RequestParam(defaultValue = "1") int page,
                                          @RequestParam(defaultValue = "10") int limit,
                                          @RequestParam(defaultValue = "id") String field,
                                          @RequestParam(defaultValue = "desc") String order){
        PageListCompany pageList = new PageListCompany();
        List<Company> list = initService.getCompanyList(page, limit, field, order);
        int count = initService.getCompanyCount();
        pageList.setCount(count);
        pageList.setData(list);
        return pageList;
    }

    @RequestMapping("deleteCompany")
    @ResponseBody
    public boolean deleteCompany(int id){
        boolean flag = false;
        try {
            flag = initService.deleteCompany(id);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return flag;
    }

    @ResponseBody
    @RequestMapping("addCompany")
    public boolean addCompany(Company company){
        boolean flag = false;
        try {
            flag = initService.insertCompany(company);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return flag;
    }

    @RequestMapping("editCompany")
    @ResponseBody
    public boolean editCompany(Company company){
        boolean flag = false;
        try {
            flag = initService.updateCompany(company);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return flag;
    }

    @RequestMapping("deleteKinds")
    @ResponseBody
    public boolean deleteKinds(String name){
        boolean flag = false;
        try {
            flag = initService.deleteKinds(name);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return flag;
    }

    @ResponseBody
    @RequestMapping("addKind")
    public boolean addKind(PageGoodsKind kind){
        boolean flag = false;
        try {
            flag = initService.addKinds(kind);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return flag;
    }
}
