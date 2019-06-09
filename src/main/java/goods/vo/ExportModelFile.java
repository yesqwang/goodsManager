package goods.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * @author 王业权
 * @功能 EasyExcel模板表对象
 * @time 2019/6/9 13:22
 */
public class ExportModelFile  extends BaseRowModel {

    @ExcelProperty(value = "物品名称" ,index = 0)
    private String name;
    @ExcelProperty(value = "类别" ,index = 1)
    private String kind;
    @ExcelProperty(value = "品牌" ,index = 2)
    private String brand;
    @ExcelProperty(value = "型号" ,index = 3)
    private String model;
    @ExcelProperty(value = "规格参数" ,index = 4)
    private String params;
    @ExcelProperty(value = "单位" ,index = 5)
    private String unit;
    @ExcelProperty(value = "库存量" ,index = 6)
    private String number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ExportModelFile{" +
                "name='" + name + '\'' +
                ", kind='" + kind + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", params='" + params + '\'' +
                ", unit='" + unit + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
