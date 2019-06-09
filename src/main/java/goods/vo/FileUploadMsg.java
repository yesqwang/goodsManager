package goods.vo;

/**
 * @author 王业权
 * @功能
 * @time 2019/6/9 14:44
 */
public class FileUploadMsg {

    private int code;
    private String msg;
    private UploadFileMsg2 data;

    public FileUploadMsg(){
        UploadFileMsg2 data = new UploadFileMsg2();
        data.setSrc("");
        this.data = data;
    }

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

    public UploadFileMsg2 getData() {
        return data;
    }

    public void setData(UploadFileMsg2 data) {
        this.data = data;
    }
}

class UploadFileMsg2{
    private String src;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}