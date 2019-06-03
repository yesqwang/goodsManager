package goods.vo;

import java.util.List;

/**
 * @author 王业权
 * @功能
 * @time 2019/3/25 23:38
 */
public class GraphBar {
    List<String> xdata;
    List<Integer> sdata;

    public List<String> getXdata() {
        return xdata;
    }

    public void setXdata(List<String> xdata) {
        this.xdata = xdata;
    }

    public List<Integer> getSdata() {
        return sdata;
    }

    public void setSdata(List<Integer> sdata) {
        this.sdata = sdata;
    }

    @Override
    public String toString() {
        return "GraphBar{" +
                "xdata=" + xdata +
                ", sdata=" + sdata +
                '}';
    }
}
