package io.miragon.example.application.port.in.sendmessage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class SendMessageCommand {

    private String messageName;

    private String key;

    private Map<String, Object> data;
}