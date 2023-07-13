package io.miragon.example.application.service;

import io.miragon.example.application.port.in.DoSomethingCommand;
import io.miragon.example.application.port.in.DoSomethingResult;
import io.miragon.example.application.port.in.DoSomethingUseCase;

public class DoSomethingService implements DoSomethingUseCase {
    public DoSomethingResult doSomething(DoSomethingCommand command) {
        String result = command.getCommand() + " result";
        return new DoSomethingResult(result);
    }
}