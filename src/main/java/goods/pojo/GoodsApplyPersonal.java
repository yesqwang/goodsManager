package goods.pojo;

public class GoodsApplyPersonal {
    private Integer id;

    private String goodsName;

    private Integer goodsKind;

    private Integer goodsBrand;

    private String goodsModel;

    private String goodsParm;

    private Integer goodsUnit;

    private Integer goodsNumber;

    private Double goodsPrice;

    private Integer whoUse;

    private String whatToDo;

    private String goodsUrl;

    private String note;

    private String applyUser;

    private Integer applyCount;

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

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getWhoUse() {
        return whoUse;
    }

    public void setWhoUse(Integer whoUse) {
        this.whoUse = whoUse;
    }

    public String getWhatToDo() {
        return whatToDo;
    }

    public void setWhatToDo(String whatToDo) {
        this.whatToDo = whatToDo == null ? null : whatToDo.trim();
    }

    public String getGoodsUrl() {
        return goodsUrl;
    }

    public void setGoodsUrl(String goodsUrl) {
        this.goodsUrl = goodsUrl == null ? null : goodsUrl.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser == null ? null : applyUser.trim();
    }

    public Integer getApplyCount() {
        return applyCount;
    }

    public void setApplyCount(Integer applyCount) {
        this.applyCount = applyCount;
    }

    @Override
    public String toString() {
        return "GoodsApplyPersonal{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", goodsKind=" + goodsKind +
                ", goodsBrand=" + goodsBrand +
                ", goodsModel='" + goodsModel + '\'' +
                ", goodsParm='" + goodsParm + '\'' +
                ", goodsUnit=" + goodsUnit +
                ", goodsNumber=" + goodsNumber +
                ", goodsPrice=" + goodsPrice +
                ", whoUse=" + whoUse +
                ", whatToDo='" + whatToDo + '\'' +
                ", goodsUrl='" + goodsUrl + '\'' +
                ", note='" + note + '\'' +
                ", applyUser='" + applyUser + '\'' +
                ", applyCount=" + applyCount +
                '}';
    }
}