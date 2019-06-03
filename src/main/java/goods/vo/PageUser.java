package goods.vo;

/**
 * @author 王业权
 * @功能
 * @time 2019/3/19 10:49
 */
public class PageUser {

    private String userid;
    private String password;
    private int identity;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    @Override
    public String toString() {
        return "PageUser{" +
                "userid='" + userid + '\'' +
                ", password='" + password + '\'' +
                ", identity=" + identity +
                '}';
    }
}
