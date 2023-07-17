package io.miragon.example.application.service;

import io.miragon.example.application.port.in.startprocess.InitiateProcessStartCommand;
import io.miragon.example.application.port.in.startprocess.InitiateProcessStartUseCase;
import io.miragon.example.application.port.out.startprocess.InitiateProcessStartOutCommand;
import io.miragon.example.application.port.out.startprocess.InitiateProcessStartPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

public class InitiateProcessStartServiceTest {

    private InitiateProcessStartUseCase initiateProcessStartService;

    @Mock
    private InitiateProcessStartPort initiateProcessStartPort;

    @Captor
    private ArgumentCaptor<InitiateProcessStartOutCommand> outCommandCaptor;

    public InitiateProcessStartServiceTest() {
        new InitiateProcessStartService(initiateProcessStartPort);
    }

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        initiateProcessStartService = new InitiateProcessStartService(initiateProcessStartPort);
    }

    @Test
    public void testInitiateProcessStart_Success() {
        String processKey = "my-process";
        Mockito.doNothing().when(initiateProcessStartPort).initiateProcessStart(Mockito.any());
        initiateProcessStartService.initiateProcessStart(new InitiateProcessStartCommand(processKey, Map.of()));
        verify(initiateProcessStartPort).initiateProcessStart(outCommandCaptor.capture());
        InitiateProcessStartOutCommand capturedCommand = outCommandCaptor.getValue();
        assertEquals(processKey, capturedCommand.getProcessKey());
        assertEquals(Map.of(), capturedCommand.getData());
    }

    @Test
    public void testInitiateProcessStart_Failure() {
        String processKey = "my-process";
        Mockito.doThrow(RuntimeException.class).when(initiateProcessStartPort).initiateProcessStart(Mockito.any());
        assertThrows(RuntimeException.class, () -> initiateProcessStartService.initiateProcessStart(new InitiateProcessStartCommand(processKey, Map.of())));
        verify(initiateProcessStartPort).initiateProcessStart(outCommandCaptor.capture());
        InitiateProcessStartOutCommand capturedCommand = outCommandCaptor.getValue();
        assertEquals(processKey, capturedCommand.getProcessKey());
        assertEquals(Map.of(), capturedCommand.getData());
    }
}