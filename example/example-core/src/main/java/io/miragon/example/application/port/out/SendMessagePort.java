package io.miragon.example.application.port.out;

import java.util.Map;

public interface SendMessagePort {

    void sendMessage(final String messageName, final Map<String, Object> data);
}