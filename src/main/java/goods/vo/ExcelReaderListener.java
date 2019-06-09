package goods.vo;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 王业权
 * @功能
 * @time 2019/6/9 15:11
 */
public class ExcelReaderListener extends AnalysisEventListener<ExportModelFile> {

    private List<ExportModelFile> list;

    public ExcelReaderListener() {
        list = new LinkedList<>();
    }

    @Override
    public void invoke(ExportModelFile object, AnalysisContext context) {
        list.add(object);
        System.out.println(object);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    public List<ExportModelFile> getList() {
        return list;
    }
}
