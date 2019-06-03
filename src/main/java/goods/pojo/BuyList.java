package goods.pojo;

import java.util.Date;

public class BuyList {
    private Integer id;

    private Date pid;

    private String goodsName;

    private Integer goodsKind;

    private Integer goodsBrand;

    private String goodsModel;

    private String goodsParm;

    private Double goodsPrice;

    private Integer goodsUnit;

    private Integer goodsNumber;

    private String completeStatus;

    private Date willCompleteDate;

    private Date completeDate;

    private Integer realBuyNumber;

    private String note;

    private Integer buyCompany;

    private String user;

    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPid() {
        return pid;
    }

    public void setPid(Date pid) {
        this.pid = pid;
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

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
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

    public String getCompleteStatus() {
        return completeStatus;
    }

    public void setCompleteStatus(String completeStatus) {
        this.completeStatus = completeStatus == null ? null : completeStatus.trim();
    }

    public Date getWillCompleteDate() {
        return willCompleteDate;
    }

    public void setWillCompleteDate(Date willCompleteDate) {
        this.willCompleteDate = willCompleteDate;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    public Integer getRealBuyNumber() {
        return realBuyNumber;
    }

    public void setRealBuyNumber(Integer realBuyNumber) {
        this.realBuyNumber = realBuyNumber;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Integer getBuyCompany() {
        return buyCompany;
    }

    public void setBuyCompany(Integer buyCompany) {
        this.buyCompany = buyCompany;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}