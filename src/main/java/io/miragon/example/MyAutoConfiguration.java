package io.miragon.example;

import io.miragon.miranum.connect.message.api.MessageApi;
import io.miragon.miranum.connect.process.impl.StartProcessPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAutoConfiguration {

    @Bean
    public MyWorker myWorker() {
        return new MyWorker();
    }

    @Bean
    public MyMessageCorrelation myMessageCorrelation(final MessageApi messageApi) {
        return new MyMessageCorrelation(messageApi);
    }

    @Bean
    public MyProcessStart myProcessStart(final StartProcessPort startProcessPort) {
        return new MyProcessStart (startProcessPort);
    }
}