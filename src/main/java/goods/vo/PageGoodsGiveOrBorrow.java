package goods.vo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 王业权
 * @功能
 * @time 2019/3/12 11:03
 */
public class PageGoodsGiveOrBorrow extends PageGoodsStore{
    int gbid;
    int number;
    String username;
    String borrowTime;
    String status;
    String busername;
    String willReturnDate;
    int reNumber;
    String reDate;
    String reusername;
    String note;

    private static Map<String, String> colsMap = new HashMap<>();
    static {
        colsMap.put("goodsId","goods_id");
        colsMap.put("number","number");
        colsMap.put("username", "user_id");
        colsMap.put("borrowTime","borrow_date");
        colsMap.put("status","status");
        colsMap.put("gbid","gbid");
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

    public int getReNumber() {
        return reNumber;
    }

    public String getReDate() {
        return reDate;
    }

    public void setReDate(String reDate) {
        this.reDate = reDate;
    }

    public String getReusername() {
        return reusername;
    }

    public void setReusername(String reusername) {
        this.reusername = reusername;
    }

    public void setReNumber(int reNumber) {
        this.reNumber = reNumber;
    }

    public PageGoodsGiveOrBorrow(){}

    public PageGoodsGiveOrBorrow(PageGoodsStore store){
        this.setGoodsId(store.getGoodsId());
        this.setGoodsName(store.getGoodsName());
        this.setGoodsKind(store.getGoodsKind());
        this.setGoodsBrand(store.getGoodsBrand());
        this.setGoodsModel(store.getGoodsModel());
        this.setGoodsPram(store.getGoodsPram());
        this.setGoodsUnit(store.getGoodsUnit());
    }

    public int getGbid() {
        return gbid;
    }

    public void setGbid(int gbid) {
        this.gbid = gbid;
    }

    public int getNumber() {
        return number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(String borrowTime) {
        this.borrowTime = borrowTime;
    }

    public String getBusername() {
        return busername;
    }

    public void setBusername(String busername) {
        this.busername = busername;
    }

    public String getWillReturnDate() {
        return willReturnDate;
    }

    public void setWillReturnDate(String willReturnDate) {
        this.willReturnDate = willReturnDate;
    }

    @Override
    public String getNote() {
        return note;
    }

    @Override
    public void setNote(String note) {
        this.note = note;
    }
}
