package goods.vo;

import java.util.Date;

/**
 * @author 王业权
 * @功能
 * @time 2019/3/22 16:30
 */
public class PageBuyLists {
    String pid;
    String cname;
    String uname;
    String phone;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "PageBuyLists{" +
                "pid='" + pid + '\'' +
                ", cname='" + cname + '\'' +
                ", uname='" + uname + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
