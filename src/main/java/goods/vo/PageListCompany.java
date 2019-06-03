package goods.vo;

import goods.pojo.Company;

import java.util.List;

/**
 * @author 王业权
 * @功能 用于封装layui数据表格的bean
 * @time 2019/3/12 15:04
 */
public class PageListCompany {

   private int code;
   private String msg;
   private int count;
   private List<Company> data;

   public int getCode() {
      return code;
   }

   public void setCode(int code) {
      this.code = code;
   }

   public String getMsg() {
      return msg;
   }

   public void setMsg(String msg) {
      this.msg = msg;
   }

   public int getCount() {
      return count;
   }

   public void setCount(int count) {
      this.count = count;
   }

   public List<Company> getData() {
      return data;
   }

   public void setData(List<Company> data) {
      this.data = data;
   }
}
