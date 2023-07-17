package io.miragon.example;

import io.miragon.example.adapter.in.miranum.MiranumInAutoConfiguration;
import io.miragon.example.adapter.out.miranum.MiranumOutAutoConfiguration;
import io.miragon.example.application.port.in.dosomething.DoSomethingUseCase;
import io.miragon.example.application.port.in.sendmessage.SendMessageUseCase;
import io.miragon.example.application.port.in.startprocess.InitiateProcessStartUseCase;
import io.miragon.example.application.port.out.sendmessage.SendMessagePort;
import io.miragon.example.application.port.out.startprocess.InitiateProcessStartPort;
import io.miragon.example.application.service.DoSomethingService;
import io.miragon.example.application.service.InitiateProcessStartService;
import io.miragon.example.application.service.SendMessageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        MiranumInAutoConfiguration.class,
        MiranumOutAutoConfiguration.class
})
public class ExampleAutoConfiguration {

    @Bean
    public DoSomethingUseCase doSomethingUseCase() {
        return new DoSomethingService();
    }

    @Bean
    public SendMessageUseCase sendMessageUseCase(final SendMessagePort sendMessagePort) {
        return new SendMessageService(sendMessagePort);
    }

    @Bean
    public InitiateProcessStartUseCase initiateProcessStartUseCase(final InitiateProcessStartPort initiateProcessStartPort) {
        return new InitiateProcessStartService(initiateProcessStartPort);
    }
}