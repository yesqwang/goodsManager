package goods.controller;

import goods.service.InitService;
import goods.vo.GraphBar;
import goods.vo.GraphItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author 王业权
 * @功能 页面通过ajax加载页面参数
 * @time 2019/3/12 13:31
 */
@RestController
@RequestMapping("initPage")
public class InitPageController {

    @Autowired
    InitService initService;

    /**
     * 获取物品类型
     * @return
     */
    @RequestMapping("/getAllGoodsKinds")
    public List<String> getAllGoodsKinds(){
        return initService.getAllGoodsKind();
    }

    /**
     * 获取物品品牌
     * @return
     */
    @RequestMapping("/getAllGoodsBrands")
    public List<String> getAllGoodsBrands(){
        return initService.getAllGoodsBrands();
    }

    /**
     * 获取物品单位
     * @return
     */
    @RequestMapping("/getAllGoodsUnit")
    public List<String> getAllGoodsUnit(){
        return initService.getAllGoodsUnit();
    }

    /**
     * 获取物品使用对象
     * @return
     */
    @RequestMapping("/getAllGoodsUser")
    public List<String> getAllGoodsUser(){
        return initService.getAllGoodsUser();
    }

    @RequestMapping("getAllCompany")
    public List<String> getAllCompany(){
        return initService.getAllCompany();
    }

    @RequestMapping("getAllCompanyUserAndPhone")
    public List<String> getAllCompanyUserAndPhone(String com){
        return initService.getCompanyMessage(com);
    }

    @RequestMapping("getGraph")
    public List<GraphItem> getGraph(){
        return initService.getGraphBar();
    }
}
