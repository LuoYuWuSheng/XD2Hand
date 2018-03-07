package site.luoyu.listner;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by luoyu on 2018/3/7.
 * 用来加载WebContext
 */
public class WebContextListener implements ServletContextListener {

    private ServletContext context;
    private String WebApplicationPath;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        this.context = sce.getServletContext();
        this.WebApplicationPath = context.getContextPath();
        String path = context.getInitParameter("PictureLocation");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
