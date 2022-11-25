package com.study.mvc;


import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.WebApplicationContext;

public class HelloServlet extends HttpServlet {

  @Override
  public void init(){
    System.out.println("init");
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    System.out.println("doGet");
    WebApplicationContext rootWebApplicationContext = (WebApplicationContext) getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
    HelloService helloService = rootWebApplicationContext.getBean(HelloService.class);
    response.getWriter().println(helloService.sayHi());
  }

  @Override
  public void destroy(){
    System.out.println("destroy");
  }
}
