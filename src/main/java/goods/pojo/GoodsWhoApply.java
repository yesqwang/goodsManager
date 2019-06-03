package goods.pojo;

public class GoodsWhoApply {
    private Integer id;

    private Integer goodsApplyId;

    private String goodsApplyer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsApplyId() {
        return goodsApplyId;
    }

    public void setGoodsApplyId(Integer goodsApplyId) {
        this.goodsApplyId = goodsApplyId;
    }

    public String getGoodsApplyer() {
        return goodsApplyer;
    }

    public void setGoodsApplyer(String goodsApplyer) {
        this.goodsApplyer = goodsApplyer == null ? null : goodsApplyer.trim();
    }
}