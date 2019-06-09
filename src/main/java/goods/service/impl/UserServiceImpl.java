package goods.service.impl;

import goods.mapper.IdentitysMapper;
import goods.mapper.UserIdentityMapper;
import goods.mapper.UserMapper;
import goods.pojo.*;
import goods.service.UserService;
import goods.vo.PageUser;
import goods.vo.PageUserShow;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 王业权
 * @功能
 * @time 2019/3/18 21:06
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    Logger log = Logger.getLogger(UserService.class);

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserIdentityMapper userIdentityMapper;
    @Autowired
    IdentitysMapper identitysMapper;

    private static String NORMAL = "normal";
    private static String ADMIN = "admin";
    private static String ADMIN_AND_NORMAL = "both";


    @Override
    public boolean checkUser(PageUser pageUser) {
        if(pageUser == null){
            return false;
        }
        String uid = pageUser.getUserid();
        String upwd = pageUser.getPassword();
        User user = userMapper.selectByPrimaryKey(uid);
        if(user == null){
            return false;
        }
        if (user.getUserPassword().equals(upwd)){
            UserIdentityExample example = new UserIdentityExample();
            UserIdentityExample.Criteria criteria = example.createCriteria();
            criteria.andUidEqualTo(uid);
            criteria.andIidEqualTo(pageUser.getIdentity());
            List<UserIdentityKey> list = userIdentityMapper.selectByExample(example);
            if (list != null && list.size()>0){
                return true;
            }
        }
        return false;
    }

    public PageUserShow changeUserToPageUserShow(User user){
        PageUserShow puser = new PageUserShow();
        puser.setUserid(user.getUserId());
        puser.setUsername(user.getUserName());
        puser.setPassword(user.getUserPassword());
        puser.setCollege(user.getCollege());
        puser.setDepartment(user.getDepartment());
        puser.setSex(user.getUserSex());
        //身份
        UserIdentityExample example = new UserIdentityExample();
        UserIdentityExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(user.getUserId());
        List<UserIdentityKey> idks = userIdentityMapper.selectByExample(example);
        if(idks.size() == 1) {
            int iid = idks.get(0).getIid();
            Identitys identitys = identitysMapper.selectByPrimaryKey(iid);
            puser.setIdentity(identitys.getIdentity());
        }else {
            puser.setIdentity("管理员+普通用户");
        }
        return puser;
    }

    @Override
    public List<PageUserShow> getUserList(int page, int limit, String field, String order) {
        UserExample example = new UserExample();
        example.setLimit(limit);
        example.setOffset((page-1)*limit);
        example.setOrderByClause(PageUserShow.getDbColName(field) + " " + order);
        List<PageUserShow> userShows = new LinkedList<>();
        List<User> users = userMapper.selectByExample(example);
        for (User u : users){
            PageUserShow us = changeUserToPageUserShow(u);
            userShows.add(us);
        }

        return userShows;
    }

    public User changePageUserShowToUser(PageUserShow show){
        User user = new User();
        user.setUserId(show.getUserid());
        user.setUserName(show.getUsername());
        user.setUserPassword(show.getPassword());
        if(show.getSex()!=null) {
            user.setUserSex(show.getSex().equals("man") ? "男" : "女");
        }
        user.setCollege(show.getCollege());
        user.setDepartment(show.getDepartment());
        return user;
    }

    public Identitys getIdentityIdByName(String name){
        IdentitysExample example = new IdentitysExample();
        IdentitysExample.Criteria criteria = example.createCriteria();
        criteria.andIdentityEqualTo(name);
        List<Identitys> ls = identitysMapper.selectByExample(example);
        if(ls.size() >0){
            return ls.get(0);
        }
        return null;
    }

    @Override
    public boolean insertIntoUser(PageUserShow show) {
        System.out.println(show);
        User user = changePageUserShowToUser(show);
        userMapper.insert(user);

        if(show.getIdentity().equals("normal") || show.getIdentity().equals("admin")){
            UserIdentityKey userIdentityKey = new UserIdentityKey();
            userIdentityKey.setUid(show.getUserid());
            Identitys identitys = getIdentityIdByName(show.getIdentity().equals("normal")?"普通用户":"物管员");
            userIdentityKey.setIid(identitys.getIid());
            userIdentityMapper.insert(userIdentityKey);
        }else if(show.getIdentity().equals("both")){
            UserIdentityKey userIdentityKey1 = new UserIdentityKey();
            userIdentityKey1.setUid(show.getUserid());
            Identitys identitys = getIdentityIdByName("普通用户");
            userIdentityKey1.setIid(identitys.getIid());
            userIdentityMapper.insert(userIdentityKey1);

            UserIdentityKey userIdentityKey2 = new UserIdentityKey();
            userIdentityKey2.setUid(show.getUserid());
            Identitys identitys1 = getIdentityIdByName("物管员");
            userIdentityKey2.setIid(identitys1.getIid());
            userIdentityMapper.insert(userIdentityKey2);
        }
        return true;
    }

    @Override
    public boolean deleteUser(String id) {
        UserIdentityExample example = new UserIdentityExample();
        UserIdentityExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(id);
        userIdentityMapper.deleteByExample(example);
        userMapper.deleteByPrimaryKey(id);
        return true;
    }

    @Override
    public boolean editUser(PageUserShow show) {
        User user = changePageUserShowToUser(show);
        user.setUserSex(show.getSex());
        userMapper.updateByPrimaryKeySelective(user);
        return true;
    }

    @Override
    public int getUserCount() {
        UserExample example = new UserExample();
        return (int)userMapper.countByExample(example);
    }

    @Override
    public PageUserShow getUserByUserId(String user) {
        User user1 = userMapper.selectByPrimaryKey(user);
        if(user != null){
            PageUserShow show = changeUserToPageUserShow(user1);
            show.setPassword("");
            return show;
        }
        return null;
    }

    @Override
    public boolean updateUserMessage(PageUserShow userShow) {
        User user = changePageUserShowToUser(userShow);
        user.setUserId(userShow.getUserid());
        //System.out.println(userShow);
        //System.out.println(user);
        userMapper.updateByPrimaryKeySelective(user);
        return true;
    }

    @Override
    public boolean updateUserPassword(String userid, String oldpassword, String newpassword) {
        User user = userMapper.selectByPrimaryKey(userid);
        if (user.getUserPassword().equals(oldpassword)){
            user.setUserPassword(newpassword);
            userMapper.updateByPrimaryKeySelective(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean changeRole(String userid, String identity) {
        log.info("用户id=" + userid + "，身份=" + identity);
        if(null == identity || "".equals(identity.trim())){
            return false;
        }
        if(userid.equals(ADMIN)){
            return false;
        }
        // 查已有身份
        UserIdentityExample example = new UserIdentityExample();
        UserIdentityExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(userid);
        List<UserIdentityKey> roleList = userIdentityMapper.selectByExample(example);

        boolean flag = false; //标记是否已有该权限
        if(identity.equals(ADMIN)){
            for(UserIdentityKey role : roleList){
                if(role.getIid()==1){
                    userIdentityMapper.deleteByPrimaryKey(role);
                }else if(role.getIid() == 2){
                    flag = true;
                }
            }
            if(!flag){
                UserIdentityKey key = new UserIdentityKey();
                key.setIid(2);
                key.setUid(userid);
                userIdentityMapper.insert(key);
            }
        }else if(identity.equals(NORMAL)){
            for(UserIdentityKey role : roleList){
                if(role.getIid()==2){
                    userIdentityMapper.deleteByPrimaryKey(role);
                }else if(role.getIid() == 1){
                    flag = true;
                }
            }
            if(!flag){
                UserIdentityKey key = new UserIdentityKey();
                key.setIid(1);
                key.setUid(userid);
                userIdentityMapper.insert(key);
            }
        }else if(identity.equals(ADMIN_AND_NORMAL)){
            boolean flag2 = false;
            for(UserIdentityKey role : roleList){
                if(role.getIid()==1){
                    flag = true;
                }else if(role.getIid() == 2){
                    flag2 = true;
                }
            }
            if(!flag){
                UserIdentityKey key = new UserIdentityKey();
                key.setIid(1);
                key.setUid(userid);
                userIdentityMapper.insert(key);
            }
            if(!flag2){
                UserIdentityKey key = new UserIdentityKey();
                key.setIid(2);
                key.setUid(userid);
                userIdentityMapper.insert(key);
            }
        }
        return true;
    }
}
