package io.miragon.example.adapter.out;

import io.miragon.example.application.port.out.SendMessagePort;
import io.miragon.miranum.connect.message.api.CorrelateMessageCommand;
import io.miragon.miranum.connect.message.api.MessageApi;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class MiranumMessageAdapter implements SendMessagePort {

    private final MessageApi messageApi;

    @Override
    public void sendMessage(String messageName, String key, Map<String, Object> data) {
        var command = new CorrelateMessageCommand(messageName, key, data);
        messageApi.correlateMessage(command);
    }
}