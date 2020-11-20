package cn.mldn.mldncloud.consumer;	
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.Bean;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@SpringBootApplication
@EnableTurbine							// 启用Turbine
public class StartTurbineApplication {
	public static void main(String[] args) {
		SpringApplication.run(StartTurbineApplication.class, args);
	}
	
//	@Bean
//	  public ServletRegistrationBean getServlet() {
//	    HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
//	    ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
//	    registrationBean.setLoadOnStartup(1);
//	    registrationBean.addUrlMappings("/hystrix.stream");
//	    registrationBean.setName("HystrixMetricsStreamServlet");
//	    return registrationBean;
//	  }
}
 