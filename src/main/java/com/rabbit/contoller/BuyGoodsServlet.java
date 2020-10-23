package com.rabbit.contoller;

import com.rabbit.service.BuyGoodsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import java.io.IOException;

public class BuyGoodsServlet extends javax.servlet.http.HttpServlet {
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Integer gid = Integer.parseInt(request.getParameter("gid"));
        Integer amount = Integer.parseInt(request.getParameter("amount"));

//        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");

//        Object obj = getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
//        WebApplicationContext ctx = null;
//       if (obj != null) {
//           ctx = (WebApplicationContext) obj;
//       }
        ServletContext sc = getServletContext();
        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);


        BuyGoodsService buyGoodsService = (BuyGoodsService)ctx.getBean("buyGoodsService");
        System.out.println(buyGoodsService.getClass());
        Boolean res = buyGoodsService.buyGoods(gid, amount);
        if (res) {
            request.getRequestDispatcher(request.getContextPath() + "/buysuccess.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher(request.getContextPath() + "/buyfail.jsp").forward(request, response);
        }
    }
}
