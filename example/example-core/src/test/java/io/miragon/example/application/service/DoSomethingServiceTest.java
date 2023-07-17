package io.miragon.example.application.service;

import io.miragon.example.application.port.in.dosomething.DoSomethingCommand;
import io.miragon.example.application.port.in.dosomething.DoSomethingResult;
import io.miragon.example.application.port.in.dosomething.DoSomethingUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoSomethingServiceTest {

    private DoSomethingUseCase doSomethingService;

    public DoSomethingServiceTest() {
        doSomethingService = new DoSomethingService();
    }

    @BeforeEach
    public void setUp() {
        doSomethingService = new DoSomethingService();
    }

    @Test
    public void testDoSomething() {
        String command = "example command";
        DoSomethingCommand doSomethingCommand = new DoSomethingCommand(command);
        DoSomethingResult result = doSomethingService.doSomething(doSomethingCommand);
        Assertions.assertEquals(command + " result", result.getResult());
    }
}