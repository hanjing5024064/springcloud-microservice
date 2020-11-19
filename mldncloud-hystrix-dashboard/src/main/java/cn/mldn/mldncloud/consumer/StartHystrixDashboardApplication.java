package cn.mldn.mldncloud.consumer;	
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard					// 启动HystrixDashboard
public class StartHystrixDashboardApplication {
	public static void main(String[] args) {
		SpringApplication.run(StartHystrixDashboardApplication.class, args);
	}
}
 