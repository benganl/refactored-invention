package za.co.wyzetect.smartcontract.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import jakarta.servlet.ServletContext;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"za.co.wyzetect.smartcontract"})
public class AppConfig {
  private static final Logger LOG = LoggerFactory.getLogger(AppConfig.class);

  @Bean
  SpringResourceTemplateResolver templateResolver() {
    LOG.info("Setting up the template resolver");
    SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
    templateResolver.setPrefix("classpath:/WEB-INF/templates/");
    templateResolver.setSuffix(".html");
    templateResolver.setTemplateMode("HTML");
    templateResolver.setCacheable(false);
    return templateResolver;
  }

  @Bean
  SpringTemplateEngine templateEngine(SpringResourceTemplateResolver resolver) {
    LOG.info("Setting up the template engine");
    SpringTemplateEngine engine = new SpringTemplateEngine();
    engine.setEnableSpringELCompiler(true);
    engine.setTemplateResolver(resolver);
    return engine;
  }

  @Bean
  ViewResolver viewResolver(SpringTemplateEngine templateEngine, ServletContext servletContext) {
    LOG.info("Setting up the view resolver");
    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
    viewResolver.setServletContext(servletContext);
    viewResolver.setTemplateEngine(templateEngine);
    viewResolver.setCache(false);
    return viewResolver;
  }
}
