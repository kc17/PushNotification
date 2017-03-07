package push.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import push.infra.AppParamMethodArgumentResolver;

@Configuration
@EnableWebMvc
@Import({PersistenceConfig.class})
@ComponentScan(basePackages = "push")
@PropertySource({ "classpath:base.properties" })
public class WebApplicationConfig extends WebMvcConfigurerAdapter {

	// inject property value automatically 
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		return configurer;
	}
	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setMaxUploadSize(4194304L);
		resolver.setDefaultEncoding("utf-8");
		return resolver;
	}
	
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(appMethodArgumentResolver());
	}
	
	@Bean
	public AppParamMethodArgumentResolver appMethodArgumentResolver() {
		return new AppParamMethodArgumentResolver();
	}
	
	
}
