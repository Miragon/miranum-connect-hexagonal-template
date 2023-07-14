package io.miragon.example.adapter.in.miranum;

import io.miragon.example.application.port.in.dosomething.DoSomethingUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MiranumInAutoConfiguration {

    @Bean
    public MiranumWorkerAdapter miranumWorkerAdapter(final DoSomethingUseCase doSomethingUseCase) {
        return new MiranumWorkerAdapter(doSomethingUseCase);
    }
}