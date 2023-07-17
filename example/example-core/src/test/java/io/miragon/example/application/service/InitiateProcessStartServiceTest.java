package io.miragon.example.application.service;

import io.miragon.example.application.port.in.startprocess.InitiateProcessStartCommand;
import io.miragon.example.application.port.in.startprocess.InitiateProcessStartUseCase;
import io.miragon.example.application.port.out.startprocess.InitiateProcessStartOutCommand;
import io.miragon.example.application.port.out.startprocess.InitiateProcessStartPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class InitiateProcessStartServiceTest {

    private InitiateProcessStartUseCase initiateProcessStartService;

    private InitiateProcessStartPort initiateProcessStartPort;

    private ArgumentCaptor<InitiateProcessStartOutCommand> outCommandCaptor;

    @BeforeEach
    public void setUp() {
        initiateProcessStartPort = mock(InitiateProcessStartPort.class);
        outCommandCaptor = ArgumentCaptor.forClass(InitiateProcessStartOutCommand.class);
        initiateProcessStartService = new InitiateProcessStartService(initiateProcessStartPort);
    }

    @Test
    public void testInitiateProcessStart_Success() {
        String processKey = "my-process";
        doNothing().when(initiateProcessStartPort).initiateProcessStart(any());
        initiateProcessStartService.initiateProcessStart(new InitiateProcessStartCommand(processKey, Map.of()));
        verify(initiateProcessStartPort).initiateProcessStart(outCommandCaptor.capture());
        InitiateProcessStartOutCommand capturedCommand = outCommandCaptor.getValue();
        assertEquals(processKey, capturedCommand.getProcessKey());
        assertEquals(Map.of(), capturedCommand.getData());
    }

    @Test
    public void testInitiateProcessStart_Failure() {
        String processKey = "my-process";
        doThrow(RuntimeException.class).when(initiateProcessStartPort).initiateProcessStart(any());
        assertThrows(RuntimeException.class, () -> initiateProcessStartService.initiateProcessStart(new InitiateProcessStartCommand(processKey, Map.of())));
        verify(initiateProcessStartPort).initiateProcessStart(outCommandCaptor.capture());
        InitiateProcessStartOutCommand capturedCommand = outCommandCaptor.getValue();
        assertEquals(processKey, capturedCommand.getProcessKey());
        assertEquals(Map.of(), capturedCommand.getData());
    }
}
