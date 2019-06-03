package goods.filter;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 王业权
 * @功能
 * @time 2019/3/8 17:33
 */
@ServletComponentScan
@WebFilter(urlPatterns = "*.html", filterName = "filterForPermission")
public class FilterForPermission implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void destroy() { }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //System.out.println("filter do it");
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpSession session = request.getSession();
        String uname = (String) session.getAttribute("user");
        if (null != uname){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            String url = request.getRequestURI();
            Pattern p=Pattern.compile("(/js/*)|(/layui/*)|(/img/*)|(/login/*)");
            Matcher m=p.matcher(url);
            if(url.equals("/") || url.equals("/index.html") || m.find()){
                filterChain.doFilter(servletRequest,servletResponse);
            }else {
                ((HttpServletResponse)servletResponse).sendRedirect(request.getContextPath() + "/index.html");
            }
        }

    }
}
