package io.miragon.example.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DoSomethingCommand {

    private String command;
}