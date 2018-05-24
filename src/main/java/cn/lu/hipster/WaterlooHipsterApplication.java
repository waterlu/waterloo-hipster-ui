package cn.lu.hipster;

import cn.lu.web.annotation.EnableWaterlooWeb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableWaterlooWeb
public class WaterlooHipsterApplication {

	public static void main(String[] args) {
		SpringApplication.run(WaterlooHipsterApplication.class, args);
	}
}
