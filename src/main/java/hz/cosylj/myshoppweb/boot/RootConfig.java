package hz.cosylj.myshoppweb.boot;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by cosy on 2016/10/24.
 */


/*@Configuration


@ImportResource(value = {"classpath:spring-jpa.xml"})
@Import({LoggingConfig.class, CommonClientSpringConfig.class})
@EnableJpaRepositories(basePackages = "hz.cosylj.myshoppweb.repository",
                        entityManagerFactoryRef = "EntityManagerFactoryBean"
                       )
@ImportResource(value = {"classpath:spring-datasource-access.xml"})
@EnableScheduling*/
public class RootConfig {
}
