package goods.pojo;

public class GoodsUser {
    private Integer guid;

    private String goodsUserName;

    public Integer getGuid() {
        return guid;
    }

    public void setGuid(Integer guid) {
        this.guid = guid;
    }

    public String getGoodsUserName() {
        return goodsUserName;
    }

    public void setGoodsUserName(String goodsUserName) {
        this.goodsUserName = goodsUserName == null ? null : goodsUserName.trim();
    }
}