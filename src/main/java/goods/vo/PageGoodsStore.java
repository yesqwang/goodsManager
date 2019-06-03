package goods.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王业权
 * @功能
 * @time 2019/3/12 11:03
 */
public class PageGoodsStore {
    int goodsId;
    String goodsName;
    String goodsKind;
    String goodsBrand;
    String goodsModel;
    String goodsPram;
    int goodsNumber;
    String goodsUnit;
    int borrowNumber;
    int giveNumber;
    String note;

    private static Map<String, String> colsMap = new HashMap<>();
    static {
        colsMap.put("goodsId","id");
        colsMap.put("goodsName","goods_name");
        colsMap.put("goodsKind","goods_kind");
        colsMap.put("goodsBrand","goods_brand");
        colsMap.put("goodsModel","goods_model");
        colsMap.put("goodsPram","goods_parm");
        colsMap.put("goodsNumber","goods_number");
        colsMap.put("goodsUnit","goods_unit");
        colsMap.put("borrowNumber","goods_borrow_number");
        colsMap.put("giveNumber","goods_give_number");
        colsMap.put("note","note");
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public int getBorrowNumber() {
        return borrowNumber;
    }

    public void setBorrowNumber(int borrowNumber) {
        this.borrowNumber = borrowNumber;
    }

    public int getGiveNumber() {
        return giveNumber;
    }

    public void setGiveNumber(int giveNumber) {
        this.giveNumber = giveNumber;
    }

    @Override
    public String toString() {
        return "PageGoodsStore{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsKind='" + goodsKind + '\'' +
                ", goodsBrand='" + goodsBrand + '\'' +
                ", goodsModel='" + goodsModel + '\'' +
                ", goodsPram='" + goodsPram + '\'' +
                ", goodsNumber=" + goodsNumber +
                ", goodsUnit='" + goodsUnit + '\'' +
                ", borrowNumber=" + borrowNumber +
                ", giveNumber=" + giveNumber +
                ", note='" + note + '\'' +
                '}';
    }
}
