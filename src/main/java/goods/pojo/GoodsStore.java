package goods.pojo;

public class GoodsStore {
    private Integer id;

    private String goodsName;

    private Integer goodsKind;

    private Integer goodsBrand;

    private String goodsModel;

    private String goodsParm;

    private Integer goodsUnit;

    private Integer goodsNumber;

    private Integer goodsGiveNumber;

    private Integer goodsBorrowNumber;

    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public Integer getGoodsKind() {
        return goodsKind;
    }

    public void setGoodsKind(Integer goodsKind) {
        this.goodsKind = goodsKind;
    }

    public Integer getGoodsBrand() {
        return goodsBrand;
    }

    public void setGoodsBrand(Integer goodsBrand) {
        this.goodsBrand = goodsBrand;
    }

    public String getGoodsModel() {
        return goodsModel;
    }

    public void setGoodsModel(String goodsModel) {
        this.goodsModel = goodsModel == null ? null : goodsModel.trim();
    }

    public String getGoodsParm() {
        return goodsParm;
    }

    public void setGoodsParm(String goodsParm) {
        this.goodsParm = goodsParm == null ? null : goodsParm.trim();
    }

    public Integer getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(Integer goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public Integer getGoodsGiveNumber() {
        return goodsGiveNumber;
    }

    public void setGoodsGiveNumber(Integer goodsGiveNumber) {
        this.goodsGiveNumber = goodsGiveNumber;
    }

    public Integer getGoodsBorrowNumber() {
        return goodsBorrowNumber;
    }

    public void setGoodsBorrowNumber(Integer goodsBorrowNumber) {
        this.goodsBorrowNumber = goodsBorrowNumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}