package io.miragon.example;

import io.miragon.miranum.connect.message.api.CorrelateMessageCommand;
import io.miragon.miranum.connect.message.api.MessageApi;
import io.miragon.miranum.connect.message.impl.MessageCorrelationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

public class MyMessageCorrelationTest {

    @Mock
    private MessageApi messageApi;

    @Captor
    private ArgumentCaptor<CorrelateMessageCommand> commandCaptor;

    private MyMessageCorrelation myMessageCorrelation;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        myMessageCorrelation = new MyMessageCorrelation(messageApi);
    }

    @Test
    public void testCorrelateMessage_Success() {
        String message = "my-message";
        String correlationKey = "my-correlation-key";
        Mockito.doNothing().when(messageApi).correlateMessage(Mockito.any());
        myMessageCorrelation.correlateMessage(message, correlationKey);
        verify(messageApi).correlateMessage(commandCaptor.capture());
        CorrelateMessageCommand capturedCommand = commandCaptor.getValue();
        assertEquals(message, capturedCommand.getMessageName());
        assertEquals(correlationKey, capturedCommand.getCorrelationKey());
    }

    @Test
    public void testCorrelateMessage_Failure() {
        String message = "my-message";
        String correlationKey = "my-correlation-key";
        Mockito.doThrow(MessageCorrelationException.class).when(messageApi).correlateMessage(Mockito.any());
        assertThrows(MessageCorrelationException.class, () -> myMessageCorrelation.correlateMessage(message, correlationKey));
        verify(messageApi).correlateMessage(commandCaptor.capture());
        CorrelateMessageCommand capturedCommand = commandCaptor.getValue();
        assertEquals(message, capturedCommand.getMessageName());
        assertEquals(correlationKey, capturedCommand.getCorrelationKey());
    }
}