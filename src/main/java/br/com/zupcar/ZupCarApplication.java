package br.com.zupcar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ZupCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZupCarApplication.class, args);
	}

}
