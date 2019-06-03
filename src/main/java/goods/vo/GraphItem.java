package goods.vo;

/**
 * @author 王业权
 * @功能
 * @time 2019/3/26 11:03
 */
public class GraphItem {
    String name;
    Integer value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "GraphItem{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
