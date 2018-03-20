package hz.cosylj.myshoppweb.boot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;



import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.*;

import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;


import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import java.util.Arrays;
import java.util.List;


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


    /**
     *
     配置消息转换器
     * @param converters

    @Override
     */
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON));
        converters.add(converter);
    }







 /*   @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        //移除原来的Jackson Converter 加入新的MessageConverter
        HttpMessageConverter mappingJackson2XmlHttpMessageConverter;
        HttpMessageConverter mappingJackson2HttpMessageConverter = null;
        if (converters.stream().anyMatch(converter -> converter instanceof MappingJackson2HttpMessageConverter)) {
            mappingJackson2HttpMessageConverter = converters.stream()
                    .filter(converter -> converter instanceof MappingJackson2HttpMessageConverter)
                    .findAny().get();
            converters.remove(mappingJackson2HttpMessageConverter);
        }
        if (converters.stream().anyMatch(converter -> converter instanceof MappingJackson2XmlHttpMessageConverter)) {
            mappingJackson2XmlHttpMessageConverter = converters.stream()
                    .filter(converter -> converter instanceof MappingJackson2XmlHttpMessageConverter)
                    .findAny().get();
            converters.remove(mappingJackson2XmlHttpMessageConverter);
        }
        if (mappingJackson2HttpMessageConverter != null && !converters.contains(mappingJackson2HttpMessageConverter))
            converters.add(mappingJackson2HttpMessageConverter);
    }
*/



    @Override
    public void  addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/login").setViewName("login.html");
        registry.addViewController("/goToRegisterPage").setViewName("pages/register.html");
    }



    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        super.configureViewResolvers(registry);
         registry.viewResolver(thymeleafViewResolver());
        // registry.jsp("/",".html");
       // registry.enableContentNegotiation(new MappingJackson2JsonView());//内容协商视图解析器
    }


/**
     * 配置内容协商视图解析器规则
     * *

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        super.configureContentNegotiation(configurer);
        configurer.favorPathExtension(true)
                  .ignoreAcceptHeader(true)
                  .parameterName("mediaType")
                  .defaultContentType(MediaType.TEXT_HTML)
                  .mediaType("html", MediaType.TEXT_HTML)
                  .mediaType("json",MediaType.APPLICATION_JSON);

    }
*/


/*
 ****************************************************************

  Spring MVC视图解析器


 ****************************************************************
*/


/*
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver()
    {
        InternalResourceViewResolver  resolver=new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/");
        resolver.setSuffix(".jsp");

        return resolver;
    }*/




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
        servletContextTemplateResolver.setTemplateMode("HTML");
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
        springResourceTemplateResolver.setTemplateMode("HTML");
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
