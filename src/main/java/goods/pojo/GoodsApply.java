package goods.pojo;

import java.util.Date;

public class GoodsApply {
    private Integer id;

    private String goodsName;

    private Integer goodsKind;

    private Integer goodsBrand;

    private String goodsModel;

    private String goodsParm;

    private Integer goodsUnit;

    private Integer goodsNumber;

    private Double goodsPrice;

    private Integer whoToUse;

    private String whatToDo;

    private String url;

    private String note;

    private String applyUser;

    private Date applyDate;

    private String applyStatus;

    private Integer raalBuyNumber;

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

    public Integer getWhoToUse() {
        return whoToUse;
    }

    public void setWhoToUse(Integer whoToUse) {
        this.whoToUse = whoToUse;
    }

    public String getWhatToDo() {
        return whatToDo;
    }

    public void setWhatToDo(String whatToDo) {
        this.whatToDo = whatToDo == null ? null : whatToDo.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
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

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus == null ? null : applyStatus.trim();
    }

    public Integer getRaalBuyNumber() {
        return raalBuyNumber;
    }

    public void setRaalBuyNumber(Integer raalBuyNumber) {
        this.raalBuyNumber = raalBuyNumber;
    }
}