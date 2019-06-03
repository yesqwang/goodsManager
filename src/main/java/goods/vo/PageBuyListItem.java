package goods.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @author 王业权
 * @功能 采购清单
 * @time 2019/3/22 12:59
 */

public class PageBuyListItem extends BaseRowModel {

    private int goodsId;
    private String pid;
    private int id;
    @ExcelProperty(value = "物品名称" ,index = 0)
    private String goodsName;
    @ExcelProperty(value = "物品类型" ,index = 1)
    private String goodsKind;
    @ExcelProperty(value = "品牌" ,index = 2)
    private String goodsBrand;
    @ExcelProperty(value = "型号" ,index = 3)
    private String goodsModel;
    @ExcelProperty(value = "规格参数" ,index = 4)
    private String goodsParm;
    @ExcelProperty(value = "单价" ,index = 5)
    private double goodsPrice;
    @ExcelProperty(value = "数量" ,index = 6)
    private int goodsNumber;
    @ExcelProperty(value = "单位" ,index = 7)
    private String goodsUnit;
    @ExcelProperty(value = "采购状态" ,index = 8)
    private String status;
    @ExcelProperty(value = "采购公司" ,index = 9)
    private String complanyName;
    @ExcelProperty(value = "联系人" ,index = 10)
    private String cUser;
    @ExcelProperty(value = "联系电话" ,index = 11)
    private String phone;
    @ExcelProperty(value = "预计完成时间" ,index = 12)
    private String willCompliteDate;
    @ExcelProperty(value = "实际完成时间" ,index = 13)
    private String compliteDate;
    @ExcelProperty(value = "实际采购数量" ,index = 14)
    private int realBuyNumber;
    @ExcelProperty(value = "备注" ,index = 15)
    private String note;

    public String getPid() {
        return pid;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getComplanyName() {
        return complanyName;
    }

    public void setComplanyName(String complanyName) {
        this.complanyName = complanyName;
    }

    public String getcUser() {
        return cUser;
    }

    public void setcUser(String cUser) {
        this.cUser = cUser;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWillCompliteDate() {
        return willCompliteDate;
    }

    public void setWillCompliteDate(String willCompliteDate) {
        this.willCompliteDate = willCompliteDate;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsKind() {
        return goodsKind;
    }

    public void setGoodsKind(String goodsKind) {
        this.goodsKind = goodsKind;
    }

    public String getGoodsBrand() {
        return goodsBrand;
    }

    public void setGoodsBrand(String goodsBrand) {
        this.goodsBrand = goodsBrand;
    }

    public String getGoodsModel() {
        return goodsModel;
    }

    public void setGoodsModel(String goodsModel) {
        this.goodsModel = goodsModel;
    }

    public String getGoodsParm() {
        return goodsParm;
    }

    public void setGoodsParm(String goodsParm) {
        this.goodsParm = goodsParm;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public int getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(int goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCompliteDate() {
        return compliteDate;
    }

    public void setCompliteDate(String compliteDate) {
        this.compliteDate = compliteDate;
    }

    public int getRealBuyNumber() {
        return realBuyNumber;
    }

    public void setRealBuyNumber(int realBuyNumber) {
        this.realBuyNumber = realBuyNumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "PageBuyListItem{" +
                "goodsId=" + goodsId +
                ", pid='" + pid + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsKind='" + goodsKind + '\'' +
                ", goodsBrand='" + goodsBrand + '\'' +
                ", goodsModel='" + goodsModel + '\'' +
                ", goodsParm='" + goodsParm + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsNumber=" + goodsNumber +
                ", goodsUnit='" + goodsUnit + '\'' +
                ", status='" + status + '\'' +
                ", complanyName='" + complanyName + '\'' +
                ", cUser='" + cUser + '\'' +
                ", phone='" + phone + '\'' +
                ", willCompliteDate='" + willCompliteDate + '\'' +
                ", compliteDate='" + compliteDate + '\'' +
                ", realBuyNumber=" + realBuyNumber +
                ", note='" + note + '\'' +
                '}';
    }
}
