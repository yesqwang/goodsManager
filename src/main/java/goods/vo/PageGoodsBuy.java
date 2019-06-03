package goods.vo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 王业权
 * @功能
 * @time 2019/3/12 11:03
 */
public class PageGoodsBuy {
    int goodsId;
    String goodsName;
    String goodsKind;
    String goodsBrand;
    String goodsModel;
    String goodsPram;
    int goodsNumber;
    String goodsUnit;
    double goodsPrice;
    String whoUses;
    String whatToDo;
    String url;
    String note;
    String status;
    int realBuyNumber;

    private static Map<String, String> colsMap = new HashMap<>();
    static {
        colsMap.put("goodsId","gbid");
        colsMap.put("goodsName","goods_name");
        colsMap.put("goodsKind","goods_kind");
        colsMap.put("goodsBrand","goods_brand");
        colsMap.put("goodsModel","goods_model");
        colsMap.put("goodsPram","goods_parm");
        colsMap.put("goodsNumber","goods_number");
        colsMap.put("goodsUnit","goods_unit");
        colsMap.put("goodsPrice","goods_price");
        colsMap.put("whoUses","who_to_use");
        colsMap.put("whatToDo","what_to_do");
        colsMap.put("url","url");
        colsMap.put("note","note");
        colsMap.put("realBuyNumber","real_buy_number");
        colsMap.put("status","status");
    }

    /**
     * 获取对应的数据库字段名称
     * @param field
     * @return
     */
    public static String getDbColName(String field){
        if(colsMap.containsKey(field)){
            return colsMap.get(field);
        }
        return colsMap.get("goodsId");
    }

    public int getRealBuyNumber() {
        return realBuyNumber;
    }

    public void setRealBuyNumber(int realBuyNumber) {
        this.realBuyNumber = realBuyNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
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

    public String getGoodsPram() {
        return goodsPram;
    }

    public void setGoodsPram(String goodsPram) {
        this.goodsPram = goodsPram;
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

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getWhoUses() {
        return whoUses;
    }

    public void setWhoUses(String whoUses) {
        this.whoUses = whoUses;
    }

    public String getWhatToDo() {
        return whatToDo;
    }

    public void setWhatToDo(String whatToDo) {
        this.whatToDo = whatToDo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "PageGoodsApplyPersonal{" +
                "goodsName='" + goodsName + '\'' +
                ", goodsKind='" + goodsKind + '\'' +
                ", goodsBrand='" + goodsBrand + '\'' +
                ", goodsModel='" + goodsModel + '\'' +
                ", goodsPram='" + goodsPram + '\'' +
                ", goodsNumber=" + goodsNumber +
                ", goodsUnit='" + goodsUnit + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", whoUses='" + whoUses + '\'' +
                ", whatToDo='" + whatToDo + '\'' +
                ", url='" + url + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
