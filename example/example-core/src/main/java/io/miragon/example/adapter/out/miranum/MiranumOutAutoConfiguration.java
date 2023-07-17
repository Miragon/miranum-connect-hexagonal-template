package io.miragon.example.adapter.out.miranum;

import io.miragon.example.application.port.out.sendmessage.SendMessagePort;
import io.miragon.example.application.port.out.startprocess.InitiateProcessStartPort;
import io.miragon.miranum.connect.message.api.MessageApi;
import io.miragon.miranum.connect.process.impl.StartProcessPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MiranumOutAutoConfiguration {

    @Bean
    public InitiateProcessStartPort initiateProcessStartPort(final StartProcessPort startProcessPort) {
        return new MiranumInitiateProcessStartAdapter(startProcessPort);
    }

    @Bean
    public SendMessagePort sendMessagePort(final MessageApi messageApi) {
        return new MiranumMessageAdapter(messageApi);
    }
}