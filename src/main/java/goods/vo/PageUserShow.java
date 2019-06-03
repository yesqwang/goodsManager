package goods.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王业权
 * @功能
 * @time 2019/3/24 9:32
 */
public class PageUserShow {

    String username;
    String userid;
    String password;
    String college;
    String department;
    String sex;
    String identity;

    private static Map<String, String> colsMap = new HashMap<>();
    static {
        colsMap.put("userid","user_id");
        colsMap.put("username","user_name");
        colsMap.put("password","user_password");
        colsMap.put("college","college");
        colsMap.put("department","department");
        colsMap.put("sex","user_sex");
        /*colsMap.put("identity","goods_number");*/
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
        return colsMap.get("userid");
    }


    public String getUsername() {
        return username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Override
    public String toString() {
        return "PageUserShow{" +
                "username='" + username + '\'' +
                ", userid='" + userid + '\'' +
                ", password='" + password + '\'' +
                ", college='" + college + '\'' +
                ", department='" + department + '\'' +
                ", sex='" + sex + '\'' +
                ", identity='" + identity + '\'' +
                '}';
    }
}
