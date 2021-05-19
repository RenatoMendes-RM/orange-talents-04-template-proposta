package br.com.ot4rmsproposta.propostaot4rms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PropostaOt4RmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropostaOt4RmsApplication.class, args);
	}

}
