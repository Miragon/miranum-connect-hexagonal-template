package io.miragon.example.application.port.out.sendmessage;

public interface SendMessagePort {

    void sendMessage(final SendMessageOutCommand command);
}