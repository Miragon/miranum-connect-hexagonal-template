package io.miragon.example.application.service;

import io.miragon.example.application.port.in.sendmessage.SendMessageCommand;
import io.miragon.example.application.port.in.sendmessage.SendMessageUseCase;
import io.miragon.example.application.port.out.sendmessage.SendMessageOutCommand;
import io.miragon.example.application.port.out.sendmessage.SendMessagePort;
import io.miragon.miranum.connect.message.impl.MessageCorrelationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class SendMessageServiceTest {

    private SendMessageUseCase sendMessageService;

    private SendMessagePort sendMessagePort;

    private ArgumentCaptor<SendMessageOutCommand> sendMessageOutCommandCaptor;

    @BeforeEach
    public void setUp() {
        sendMessagePort = mock(SendMessagePort.class);
        sendMessageOutCommandCaptor = ArgumentCaptor.forClass(SendMessageOutCommand.class);
        sendMessageService = new SendMessageService(sendMessagePort);
    }

    @Test
    public void testSendMessage_Success() {
        String message = "my-message";
        String correlationKey = "my-correlation-key";
        doNothing().when(sendMessagePort).sendMessage(any());
        sendMessageService.sendMessage(new SendMessageCommand(message, correlationKey, Map.of()));
        verify(sendMessagePort).sendMessage(sendMessageOutCommandCaptor.capture());
        SendMessageOutCommand capturedCommand = sendMessageOutCommandCaptor.getValue();
        assertEquals(message, capturedCommand.getMessageName());
        assertEquals(correlationKey, capturedCommand.getKey());
    }

    @Test
    public void testSendMessage_Failure() {
        String message = "my-message";
        String correlationKey = "my-correlation-key";
        doThrow(MessageCorrelationException.class).when(sendMessagePort).sendMessage(any());
        assertThrows(MessageCorrelationException.class, () ->
                sendMessageService.sendMessage(new SendMessageCommand(message, correlationKey, Map.of())));
        verify(sendMessagePort).sendMessage(sendMessageOutCommandCaptor.capture());
        SendMessageOutCommand capturedCommand = sendMessageOutCommandCaptor.getValue();
        assertEquals(message, capturedCommand.getMessageName());
        assertEquals(correlationKey, capturedCommand.getKey());
    }
}
