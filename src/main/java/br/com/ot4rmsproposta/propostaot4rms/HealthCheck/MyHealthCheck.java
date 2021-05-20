package br.com.ot4rmsproposta.propostaot4rms.HealthCheck;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MyHealthCheck implements HealthIndicator {
    @Override
    public Health health() {
        Map<String, Object> details = new HashMap<>();
        details.put("versão", "1.1");
        details.put("descrição", "Meu scaffold de Health Check customizado!");
        details.put("endereço", "127.0.0.1");
        //System.out.println("Health");

        return Health.status(Status.UP).withDetails(details).build();

    }
}
