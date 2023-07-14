package io.miragon.example;

import io.miragon.example.adapter.in.miranum.MiranumInAutoConfiguration;
import io.miragon.example.adapter.out.miranum.MiranumOutAutoConfiguration;
import io.miragon.example.application.port.in.dosomething.DoSomethingUseCase;
import io.miragon.example.application.port.in.sendmessage.SendMessageUseCase;
import io.miragon.example.application.port.in.startprocess.InitiateProcessStartUseCase;
import io.miragon.example.application.service.DoSomethingService;
import io.miragon.example.application.service.InitiateProcessStartService;
import io.miragon.example.application.service.SendMessageService;
import io.miragon.miranum.connect.message.api.MessageApi;
import io.miragon.miranum.connect.process.impl.StartProcessPort;
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
    public SendMessageUseCase sendMessageUseCase(final MessageApi messageApi) {
        return new SendMessageService(messageApi);
    }

    @Bean
    public InitiateProcessStartUseCase initiateProcessStartUseCase(final StartProcessPort startProcessPort) {
        return new InitiateProcessStartService(startProcessPort);
    }
}