package io.miragon.example.application.port.out.sendmessage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class SendMessageOutCommand {

    private String messageName;

    private String key;

    private Map<String, Object> data;
}