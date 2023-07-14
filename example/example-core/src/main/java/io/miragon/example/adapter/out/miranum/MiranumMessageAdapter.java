package io.miragon.example.adapter.out.miranum;

import io.miragon.example.application.port.out.sendmessage.SendMessageOutCommand;
import io.miragon.example.application.port.out.sendmessage.SendMessagePort;
import io.miragon.miranum.connect.message.api.CorrelateMessageCommand;
import io.miragon.miranum.connect.message.api.MessageApi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MiranumMessageAdapter implements SendMessagePort {

    private final MessageApi messageApi;

    @Override
    public void sendMessage(SendMessageOutCommand command) {
        var correlateMessageCommand = new CorrelateMessageCommand(
                command.getMessageName(),
                command.getKey(),
                command.getData());
        messageApi.correlateMessage(correlateMessageCommand);
    }
}