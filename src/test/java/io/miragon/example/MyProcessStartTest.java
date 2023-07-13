package io.miragon.example;

import io.miragon.miranum.connect.process.api.ProcessStartingException;
import io.miragon.miranum.connect.process.api.StartProcessCommand;
import io.miragon.miranum.connect.process.impl.StartProcessPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

public class MyProcessStartTest {

    @Mock
    private StartProcessPort startProcessPort;

    private MyProcessStart myProcessStart;

    @Captor
    private ArgumentCaptor<StartProcessCommand> commandCaptor;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        myProcessStart = new MyProcessStart(startProcessPort);
    }

    @Test
    public void testStartProcess_Success() {
        String processKey = "my-process-key";
        Mockito.doNothing().when(startProcessPort).startProcess(Mockito.any());
        myProcessStart.startProcess(processKey);
        verify(startProcessPort).startProcess(commandCaptor.capture());
        StartProcessCommand capturedCommand = commandCaptor.getValue();
        assertEquals(processKey, capturedCommand.getProcessKey());
        assertNull(capturedCommand.getVariables());
    }

    @Test
    public void testStartProcess_Failure() {
        String processKey = "my-process-key";
        Mockito.doThrow(ProcessStartingException.class).when(startProcessPort).startProcess(any(StartProcessCommand.class));
        assertThrows(ProcessStartingException.class, () -> myProcessStart.startProcess(processKey));
        verify(startProcessPort).startProcess(commandCaptor.capture());
        StartProcessCommand capturedCommand = commandCaptor.getValue();
        assertEquals(processKey, capturedCommand.getProcessKey());
        assertEquals(processKey, capturedCommand.getProcessKey());
        assertNull(capturedCommand.getVariables());
    }
}