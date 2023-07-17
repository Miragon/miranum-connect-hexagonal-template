package io.miragon.example.application.service;

import io.miragon.example.application.port.in.dosomething.DoSomethingCommand;
import io.miragon.example.application.port.in.dosomething.DoSomethingResult;
import io.miragon.example.application.port.in.dosomething.DoSomethingUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

public class DoSomethingServiceTest {

    @InjectMocks
    private DoSomethingUseCase doSomethingService;

    @BeforeEach
    public void setUp() {
        doSomethingService = new DoSomethingService();
    }

    @Test
    public void testDoSomething() {
        // Arrange
        String command = "example command";
        DoSomethingCommand doSomethingCommand = new DoSomethingCommand(command);

        // Act
        DoSomethingResult result = doSomethingService.doSomething(doSomethingCommand);

        // Assert
        Assertions.assertEquals(command + " result", result.getResult());
    }
}