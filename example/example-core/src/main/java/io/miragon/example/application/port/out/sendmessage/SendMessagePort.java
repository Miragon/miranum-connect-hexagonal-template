package io.miragon.example.application.port.out.sendmessage;

import java.util.Map;

public interface SendMessagePort {

    void sendMessage(final SendMessageOutCommand command);
}