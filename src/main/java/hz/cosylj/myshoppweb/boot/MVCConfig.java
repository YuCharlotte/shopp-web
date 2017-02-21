package hz.cosylj.myshoppweb.boot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;


import org.thymeleaf.templateresolver.ServletContextTemplateResolver;




/**
 * Created by cosy on 2016/10/24.
 */

@Configuration
@EnableWebMvc
@ComponentScan({"hz.cosylj.myshoppweb.service", "hz.cosylj.myshoppweb.controller"})
@EnableJpaRepositories(basePackages = "hz.cosylj.myshoppweb.repository",
                       entityManagerFactoryRef = "EntityManagerFactoryBean"
                      )
@ImportResource(value = {"classpath:spring-datasource-access.xml"})
@EnableScheduling
public class MVCConfig extends WebMvcConfigurerAdapter  {


    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private WebApplicationContext webApplicationContext;


    public MVCConfig() {
        super();
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        // 开启默认转发
        configurer.enable();
    }



    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        super.configureViewResolvers(registry);
        registry.viewResolver(thymeleafViewResolver());
    }





/*
 ****************************************************************

  Spring MVC视图解析器


 ****************************************************************
*/



   /* @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver()
    {
        InternalResourceViewResolver  resolver=new InternalResourceViewResolver ();
        //resolver.setPrefix("/html");
       // resolver.setSuffix(".jsp");

        return resolver;
    }
*/



/*
 ****************************************************************

  THYMELEAF-SPECIFIC ARTIFACTS

  TemplateResolver <- TemplateEngine <- ViewResolver

 ****************************************************************
*/


    //暂时不用。先配着

    public ServletContextTemplateResolver viewResolver()
    {
        ServletContextTemplateResolver servletContextTemplateResolver=new ServletContextTemplateResolver(webApplicationContext.getServletContext());
        servletContextTemplateResolver.setTemplateMode("html5");
//        servletContextTemplateResolver.setPrefix("/html");
//        servletContextTemplateResolver.setSuffix(".jsp");
        servletContextTemplateResolver.setCacheTTLMs(3600000L);

        TemplateEngine templateEngine=new TemplateEngine();
        templateEngine.setTemplateResolver(servletContextTemplateResolver);
        return servletContextTemplateResolver;
    }



    public SpringResourceTemplateResolver springResourceTemplateResolver ()
    {
        SpringResourceTemplateResolver springResourceTemplateResolver=new SpringResourceTemplateResolver();
        springResourceTemplateResolver.setApplicationContext(this.applicationContext);
        springResourceTemplateResolver.setCharacterEncoding("utf-8");
        springResourceTemplateResolver.setTemplateMode("html5");
        //springResourceTemplateResolver.setPrefix("/html");
       // springResourceTemplateResolver.setSuffix(".html");
        springResourceTemplateResolver.setCacheable(true);
        return springResourceTemplateResolver;
    }


    public SpringTemplateEngine springTemplateEngine()
    {
        SpringTemplateEngine springTemplateEngine=new SpringTemplateEngine();
        springTemplateEngine.setTemplateResolver(springResourceTemplateResolver());
        springTemplateEngine.setEnableSpringELCompiler(true);
        return springTemplateEngine;
    }


    public ThymeleafViewResolver thymeleafViewResolver()
    {
        ThymeleafViewResolver thymeleafViewResolver=new ThymeleafViewResolver();
        thymeleafViewResolver.setOrder(1);
        thymeleafViewResolver.setCharacterEncoding("UTF-8");
        thymeleafViewResolver.setTemplateEngine(springTemplateEngine());
        return thymeleafViewResolver;

    }







}
