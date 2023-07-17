package io.miragon.example.application.service;

import io.miragon.example.application.port.in.dosomething.DoSomethingCommand;
import io.miragon.example.application.port.in.dosomething.DoSomethingResult;
import io.miragon.example.application.port.in.dosomething.DoSomethingUseCase;

public class DoSomethingService implements DoSomethingUseCase {

    public DoSomethingResult doSomething(DoSomethingCommand command) {
        String result = command.getCommand() + " result";
        return new DoSomethingResult(result);
    }
}