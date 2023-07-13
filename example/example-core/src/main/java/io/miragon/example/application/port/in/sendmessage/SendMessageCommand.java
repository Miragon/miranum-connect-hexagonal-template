package io.miragon.example.application.port.in.sendmessage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SendMessageCommand {

    private String message;
}