package top.fengziren;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("top.fengziren.mapper")
@SpringBootApplication
public class KaohexiangmuApplication {

	public static void main(String[] args) {
		SpringApplication.run(KaohexiangmuApplication.class, args);
	}

}