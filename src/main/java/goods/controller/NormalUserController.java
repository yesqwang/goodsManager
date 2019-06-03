package goods.controller;

import goods.mapper.GoodsBuyMapper;
import goods.service.*;
import goods.vo.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 王业权
 * @功能
 * @time 2019/3/12 10:41
 */
@Controller
@RequestMapping("normal")
public class NormalUserController {
    private static Logger logger = Logger.getLogger(NormalUserController.class);
    //private String  user = "admin";

    @Autowired
    GoodsApplyService goodsApplyService;
    @Autowired
    GoodsStoreService goodsStoreService;
    @Autowired
    GoodsBuyService buyService;
    @Autowired
    UserService userService;

    @RequestMapping("/addPersonalApply")
    @ResponseBody
    public boolean addPersonalApply(PageGoodsApplyPersonal applyPersonal, HttpSession session){
        boolean flag = false;
        String user = (String) session.getAttribute("user");
        try {
            flag = goodsApplyService.addPersonalApply(applyPersonal,user);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(),e);
        }
        return flag;
    }

    @RequestMapping("addPersonalApplys")
    @ResponseBody
    public boolean addPersonalApplys(@RequestBody List<PageGoodsApplyPersonal> datas, HttpSession session){
        boolean flag = false;
        String user = (String) session.getAttribute("user");
        try {
            flag = goodsApplyService.addPersonalApplys(datas,user);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(),e);
        }
        return flag;
    }

    /**
     * 获取个人物品申请表
     * @param page
     * @return
     */
    @RequestMapping("/getGoodsApplyPersonalList")
    @ResponseBody
    public PageListPersonalApply getGoodsApplyPersonalList(@RequestParam(defaultValue = "1") int page,
                                                           @RequestParam(defaultValue = "10") int limit,
                                                           @RequestParam(defaultValue = "goodsId") String field,
                                                           @RequestParam(defaultValue = "desc") String order,
                                                           @RequestParam(defaultValue = "") String search,
                                                           HttpSession session){
        String user = (String) session.getAttribute("user");
        PageListPersonalApply pageList = new PageListPersonalApply();
        List<PageGoodsApplyPersonal> list = goodsApplyService.getGoodsApplyPersonalList(user, page, limit, field, order, search);
        int count = goodsApplyService.getPersonApplyCount(user);
        pageList.setCount(count);
        pageList.setData(list);
        return pageList;
    }

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
     * 将个人申请表提交到申请总表
     * @param ids
     * @return
     */
    @RequestMapping("/addPersonalApplyToApply")
    @ResponseBody
    public boolean addPersonalApplyToApply(@RequestParam(value = "ids[]") Integer[] ids){
        System.out.println(ids);
        boolean flag = false;
        try {
            flag = goodsApplyService.copyPersonalApplyToApply(ids);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return flag;
    }

    /**
     * 获取申请总表
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("getGoodsApplyList")
    @ResponseBody
    public PageListApply getGoodsApplyList(@RequestParam(defaultValue = "1") int page,
                                           @RequestParam(defaultValue = "10") int limit,
                                           @RequestParam(defaultValue = "goodsId") String field,
                                           @RequestParam(defaultValue = "desc") String order,
                                           @RequestParam(defaultValue = "") String search){
        PageListApply pageList = new PageListApply();
        List<PageGoodsApply> list = goodsApplyService.getGoodsApplyList(page, limit, field, order, search);
        int count = goodsApplyService.getApplyCount();
        pageList.setCount(count);
        pageList.setData(list);
        return pageList;
    }


    /**
     * 将采购总表的内容复制到个人申请表中
     * @param ids
     * @return
     */
    @RequestMapping("addBuyToPersonalApply")
    @ResponseBody
    public boolean addBuyToPersonalApply(@RequestParam(value = "ids[]") Integer[] ids, HttpSession session){
        System.out.println(ids);
        boolean flag = false;
        String user = (String) session.getAttribute("user");
        try {
            flag = goodsApplyService.copyBuyToPersonalApply(user,ids);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return true;
    }

    /**
     * 将申请总表的内容添加到个人申请表里
     * @param ids
     * @return
     */
    @RequestMapping("/addApplyToPersonalApply")
    @ResponseBody
    public boolean addApplyToPersonalApply(@RequestParam(value = "ids[]") Integer[] ids, HttpSession session){
        System.out.println(ids);
        boolean flag = false;
        String user = (String) session.getAttribute("user");
        try {
            flag = goodsApplyService.copyApplyToPersonalApply(user,ids);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return true;
    }

    /**
     * 根据id删除个人申请表
     * @param id
     * @return
     */
    @RequestMapping("deletePersonalApply")
    @ResponseBody
    public boolean deletePersonalApply(@RequestParam int id){
        boolean flag = false;
        try {
            flag = goodsApplyService.deletePersonalApplyById(id);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(),e);
        }
        return flag;
    }

    /**
     * 批量删除个人申请表
     * @param ids
     * @return
     */
    @RequestMapping("deletePersonalApplys")
    @ResponseBody
    public boolean deletePersonalApplys(@RequestParam(value = "ids[]") Integer[] ids){
        boolean flag = false;
        try {
            flag = goodsApplyService.deletePersonalApplyByIds(ids);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(),e);
        }
        return flag;
    }

    /**
     * 获取个人提交到申请总表上的数据
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("getWhoApplyList")
    @ResponseBody
    public PageListApply getWhoApplyList(@RequestParam(defaultValue = "1") int page,
                                         @RequestParam(defaultValue = "15") int limit,
                                         HttpSession session){
        PageListApply listApply = new PageListApply();
        String user = (String) session.getAttribute("user");
        List<PageGoodsApply> list = goodsApplyService.getWhoApplyList(user, page,limit);
        int count = goodsApplyService.getWhoApplyCount(user);
        listApply.setCount(count);
        listApply.setData(list);
        return listApply;
    }

    /**
     * 获取库存表
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("getGoodsSotreList")
    @ResponseBody
    public PageListStore getGoodsSotreList(@RequestParam(defaultValue = "1") int page,
                                           @RequestParam(defaultValue = "15") int limit,
                                           @RequestParam(defaultValue = "goodsId") String field,
                                           @RequestParam(defaultValue = "desc") String order,
                                           @RequestParam(defaultValue = "") String search){
        PageListStore listStore = new PageListStore();
        List<PageGoodsStore> list = goodsStoreService.getStoreList(page, limit, field, order, search);
        int count = goodsStoreService.getStoreCount();
        listStore.setCount(count);
        listStore.setData(list);
        return listStore;
    }

    /**
     * 申请借物品
     * @return
     */
    @RequestMapping("addBorrow")
    @ResponseBody
    public boolean addBorrow(@RequestParam int gsid, @RequestParam int gnumber,
                             @RequestParam String username, @RequestParam String gusername,
                             @RequestParam String date){
        boolean flag = false;
        try {
            flag = goodsStoreService.addUserBorrowGoods(username, gsid, gnumber,gusername,date);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(),e);
        }
        return flag;
    }


    /**
     * 领取物品
     * @param gsid
     * @param gnumber
     * @return
     */
    @RequestMapping("addGive")
    @ResponseBody
    public boolean addGive(@RequestParam int gsid, @RequestParam int gnumber,
                           @RequestParam String username, @RequestParam String gusername,
                           @RequestParam String date, HttpSession session){
        boolean flag = false;
        String user = (String) session.getAttribute("user");
        try {
            flag = goodsStoreService.addUserGiveGoods(user, gsid, gnumber,gusername);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(),e);
        }
        return flag;
    }

    /**
     * 报废物品
     * @param gsid
     * @param gnumber
     * @return
     */
    @ResponseBody
    @RequestMapping("scrapGoods")
    public boolean scrapGoods(int gsid, int gnumber){
        boolean flag = false;
        try {
            flag = goodsStoreService.scrapGoods(gsid, gnumber);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(),e);
        }
        return flag;
    }

    /**
     * 获取已领取列表
     * @param page
     * @param limit
     * @return
     */
    /*@RequestMapping("getUserGoodsGive")
    @ResponseBody
    public PageListGiveOrBorrow getUserGoodsGive(@RequestParam(defaultValue = "1") int page,
                                                 @RequestParam(defaultValue = "15") int limit,
                                                 @RequestParam(defaultValue = "goodsId") String field,
                                                 @RequestParam(defaultValue = "desc") String order){
        PageListGiveOrBorrow listStore = new PageListGiveOrBorrow();
        List<PageGoodsGiveOrBorrow> list = goodsStoreService.getUserGiveOrBorrowList(false, user, page, limit, field, order);
        int count = goodsStoreService.getUserGiveOrBorrowCount(false, user);
        listStore.setCount(count);
        listStore.setData(list);
        return listStore;
    }*/

    /**
     * 获取已借列表
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("getUserGoodsBorrow")
    @ResponseBody
    public PageListGiveOrBorrow getUserGoodsBorrow(@RequestParam(defaultValue = "1") int page,
                                                   @RequestParam(defaultValue = "15") int limit,
                                                   @RequestParam(defaultValue = "goodsId") String field,
                                                   @RequestParam(defaultValue = "desc") String order,
                                                   @RequestParam(defaultValue = "") String kinds,
                                                   HttpSession session){
        String user = (String) session.getAttribute("user");
        PageListGiveOrBorrow listStore = new PageListGiveOrBorrow();
        List<PageGoodsGiveOrBorrow> list = goodsStoreService.getUserGiveOrBorrowList(user, page, limit, field, order, kinds);
        int count = goodsStoreService.getUserGiveOrBorrowCount(user, kinds);
        listStore.setCount(count);
        listStore.setData(list);
        return listStore;
    }

    /**
     * 根据id获取某个个人申请物品的信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("getGoodsMessageById")
    public PageGoodsApplyPersonal getGoodsMessageById(@RequestParam int id){
        PageGoodsApplyPersonal goodsApply = goodsApplyService.getGoodsApplyById(id);
        return goodsApply;
    }

    /**
     * 获取单个申请总表的内容
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("getApplyMessageById")
    public PageGoodsApply getApplyMessageById(@RequestParam int id){
        PageGoodsApply apply = goodsApplyService.getApplyMessageById(id);
        return apply;
    }

    /**
     * 修改单个个人申请物品信息
     * @param personal
     * @return
     */
    @RequestMapping("editPersonalApply")
    @ResponseBody
    public boolean editPersonalApply(PageGoodsApplyPersonal personal){
        boolean flag = false;
        try {
            flag = goodsApplyService.updatePersonalApply(personal);
            //System.out.println(personal);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return flag;
    }

    /**
     * 根据id删除申请总表的数据
     * @param gid
     * @return
     */
    @ResponseBody
    @RequestMapping("deleteApply")
    public boolean deleteApply(@RequestParam int gid){
        boolean flag = false;
        try {
            flag = goodsApplyService.deleteApply(gid);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
        return flag;
    }

    /**
     * 根据id批量删除申请总表
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping("deleteApplys")
    public boolean deleteApplys(@RequestParam(value = "ids[]") Integer[] ids){
        boolean flag = false;
        try {
            flag = goodsApplyService.deleteApplyByIds(ids);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(),e);
        }
        return flag;
    }

    @ResponseBody
    @RequestMapping("getUserMessage")
    public PageUserShow getUserMessage(HttpSession session){
        String user = (String) session.getAttribute("user");
        return userService.getUserByUserId(user);
    }

    @RequestMapping("updateUserMessage")
    @ResponseBody
    public boolean updateUserMessage(PageUserShow userShow){
        boolean flag = false;
        try {
            flag = userService.updateUserMessage(userShow);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(),e);
        }
        return flag;
    }

    @ResponseBody
    @RequestMapping("updatePwd")
    public boolean updatePwd(String oldpassword, String newpassword, HttpSession session){
        boolean flag = false;
        String user = (String) session.getAttribute("user");
        try {
            flag = userService.updateUserPassword(user, oldpassword, newpassword);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(),e);
        }
        return flag;
    }
}
