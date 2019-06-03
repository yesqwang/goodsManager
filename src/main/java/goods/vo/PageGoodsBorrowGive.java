package goods.vo;

/**
 * @author 王业权
 * @功能 批量借领操作
 * @time 2019/3/21 16:15
 */
public class PageGoodsBorrowGive {
    int goodId;
    int number;
    String username;
    String pusername;
    String isBorrow;
    String willReturnDate;
    String note;

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPusername() {
        return pusername;
    }

    public void setPusername(String pusername) {
        this.pusername = pusername;
    }

    public String getIsBorrow() {
        return isBorrow;
    }

    public void setIsBorrow(String isBorrow) {
        this.isBorrow = isBorrow;
    }

    public String getWillReturnDate() {
        return willReturnDate;
    }

    public void setWillReturnDate(String willReturnDate) {
        this.willReturnDate = willReturnDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "PageGoodsBorrowGive{" +
                "goodId=" + goodId +
                ", number=" + number +
                ", username='" + username + '\'' +
                ", pusername='" + pusername + '\'' +
                ", isBorrow=" + isBorrow +
                ", willReturnDate='" + willReturnDate + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
