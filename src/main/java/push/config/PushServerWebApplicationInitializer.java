package push.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class PushServerWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext paramServletContext) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(WebApplicationConfig.class);
		ctx.setServletContext(paramServletContext);

		ServletRegistration.Dynamic servlet = paramServletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
		
	}

}
