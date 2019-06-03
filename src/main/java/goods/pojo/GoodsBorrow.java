package goods.pojo;

import java.util.Date;

public class GoodsBorrow {
    private Integer gbid;

    private Integer goodsId;

    private String userId;

    private Integer number;

    private Date borrowDate;

    private String status;

    private Boolean isBorrow;

    private Date willReturnDate;

    private String borrowUserId;

    private String returnUserId;

    private Integer returnNumber;

    private Date returnDate;

    private String note;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getGbid() {
        return gbid;
    }

    public void setGbid(Integer gbid) {
        this.gbid = gbid;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Boolean getIsBorrow() {
        return isBorrow;
    }

    public void setIsBorrow(Boolean isBorrow) {
        this.isBorrow = isBorrow;
    }

    public Date getWillReturnDate() {
        return willReturnDate;
    }

    public void setWillReturnDate(Date willReturnDate) {
        this.willReturnDate = willReturnDate;
    }

    public String getBorrowUserId() {
        return borrowUserId;
    }

    public void setBorrowUserId(String borrowUserId) {
        this.borrowUserId = borrowUserId == null ? null : borrowUserId.trim();
    }

    public String getReturnUserId() {
        return returnUserId;
    }

    public void setReturnUserId(String returnUserId) {
        this.returnUserId = returnUserId == null ? null : returnUserId.trim();
    }

    public Integer getReturnNumber() {
        return returnNumber;
    }

    public void setReturnNumber(Integer returnNumber) {
        this.returnNumber = returnNumber;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "GoodsBorrow{" +
                "gbid=" + gbid +
                ", goodsId=" + goodsId +
                ", userId='" + userId + '\'' +
                ", number=" + number +
                ", borrowDate=" + borrowDate +
                ", status='" + status + '\'' +
                ", isBorrow=" + isBorrow +
                ", willReturnDate=" + willReturnDate +
                ", borrowUserId='" + borrowUserId + '\'' +
                ", returnUserId='" + returnUserId + '\'' +
                ", returnNumber=" + returnNumber +
                ", returnDate=" + returnDate +
                ", note='" + note + '\'' +
                '}';
    }
}