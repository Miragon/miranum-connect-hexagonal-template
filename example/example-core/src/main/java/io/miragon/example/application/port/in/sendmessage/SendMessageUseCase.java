package io.miragon.example.application.port.in.sendmessage;

public interface SendMessageUseCase {

    SendMessageResult sendMessage(final SendMessageCommand command);
}
