package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration //替換xml的設定方式
@ComponentScan(basePackages = {"com.*"}) //檢查被註冊為Spring的bean。有注解這些@Component，@Service，@Controller，@RestController，@Repository，@Configuration才會被讀取。
@EnableJpaRepositories("com.*") //啟用JPA倉庫
@EntityScan(basePackages = {"com.*"}) //檢查被註冊為持久層所管理的entity class，注解@Entity才會被讀取。
@SpringBootApplication //開啟自動配置。相當於宣告@Configuration、@ComponentScan、@EnableAutoConfiguration
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}
