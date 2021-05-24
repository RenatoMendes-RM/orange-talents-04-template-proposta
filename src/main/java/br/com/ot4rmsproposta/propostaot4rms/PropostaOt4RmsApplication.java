package br.com.ot4rmsproposta.propostaot4rms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
public class PropostaOt4RmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropostaOt4RmsApplication.class, args);
	}

}
