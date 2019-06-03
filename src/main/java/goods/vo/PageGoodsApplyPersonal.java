package goods.vo;

/**
 * @author 王业权
 * @功能
 * @time 2019/3/12 11:03
 */
public class PageGoodsApplyPersonal {
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
    String applyer;
    String url;
    String note;
    int applyCount;

    public int getApplyCount() {
        return applyCount;
    }

    public void setApplyCount(int applyCount) {
        this.applyCount = applyCount;
    }

    public String getApplyer() {
        return applyer;
    }

    public void setApplyer(String applyer) {
        this.applyer = applyer;
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
                "goodsId=" + goodsId+
                ", goodsName='" + goodsName + '\'' +
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
