package za.co.wyzetect.smartcontract.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ApplicationInitializer implements WebApplicationInitializer {
  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    final AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
    context.register(AppConfig.class);

    final DispatcherServlet servlet = new DispatcherServlet(context);

    final ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
    registration.addMapping("/ui", "/svc");
    
    registration.setLoadOnStartup(1);
  }
}
