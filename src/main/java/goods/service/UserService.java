package goods.service;

import goods.vo.PageUser;
import goods.vo.PageUserShow;

import java.util.List;

/**
 * 登录操作
 */
public interface UserService {

    public static final int INDENTITY_NORMAL_USER = 1;
    public static final int INDENTITY_GOODS_MANAGER= 2;
    public static final int INDENTITY_DIRECTOR_MAN = 3;


    public boolean checkUser(PageUser user);

    /**
     * 用户列表
     * @param page
     * @param limit
     * @param field
     * @param order
     * @return
     */
    List<PageUserShow> getUserList(int page, int limit, String field, String order);

    /**
     * 插入用户
     * @param show
     * @return
     */
    boolean insertIntoUser(PageUserShow show);

    /**
     * 删除用户
     * @param id
     * @return
     */
    boolean deleteUser(String id);

    boolean editUser(PageUserShow show);

    int getUserCount();

    PageUserShow getUserByUserId(String user);

    boolean updateUserMessage(PageUserShow userShow);

    boolean updateUserPassword(String userid, String oldpassword, String newpassword);
}
