package goods.controller;

import goods.service.UserService;
import goods.vo.PageUser;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 王业权
 * @功能
 * @time 2019/3/18 21:03
 */
@RequestMapping("login")
@Controller
public class LogginController {
    Logger logger = Logger.getLogger(LogginController.class);

    @Autowired
    UserService service;

    @RequestMapping(value = "userLoggin", method = RequestMethod.POST)
    public ModelAndView loggin(PageUser user, HttpSession session){
        System.out.println(user);
        ModelAndView mv = new ModelAndView();
        boolean flag = service.checkUser(user);
        if (flag) {
            int iid = user.getIdentity();
            if (iid == UserService.INDENTITY_NORMAL_USER) {
                mv.setViewName("redirect:/nhome.html");
            }else if(iid == UserService.INDENTITY_GOODS_MANAGER){
                mv.setViewName("redirect:/mhome.html");
            }else {
                mv.setViewName("redirect:/nhome.html");
            }
            session.setAttribute("user",user.getUserid());
//            return "redirect:/nhome.html";
        }else {
//            return "redirect:/index.html";
            mv.addObject("err",false);
            mv.setViewName("redirect:/index.html");
        }
        return mv;
    }

}
