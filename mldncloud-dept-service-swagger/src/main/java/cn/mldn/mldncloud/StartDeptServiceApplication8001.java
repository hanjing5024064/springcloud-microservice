package cn.mldn.mldncloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
@EnableJpaRepositories(basePackages="cn.mldn.mldncloud.dao")
public class StartDeptServiceApplication8001 {
	public static void main(String[] args) {
		SpringApplication.run(StartDeptServiceApplication8001.class, args);
	}
}
