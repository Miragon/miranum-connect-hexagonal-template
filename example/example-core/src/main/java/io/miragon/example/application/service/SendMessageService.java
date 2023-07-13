package io.miragon.example.application.service;

import io.miragon.example.application.port.in.sendmessage.SendMessageCommand;
import io.miragon.example.application.port.in.sendmessage.SendMessageResult;
import io.miragon.example.application.port.in.sendmessage.SendMessageUseCase;
import io.miragon.example.application.port.out.SendMessagePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SendMessageService implements SendMessageUseCase {

    private final SendMessagePort sendMessagePort;

    @Override
    public SendMessageResult sendMessage(SendMessageCommand command) {
        sendMessagePort.sendMessage(command.getMessage(), "key",  null);
        return new SendMessageResult("answer to: " + command.getMessage());
    }
}