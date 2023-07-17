package io.miragon.example.application.service;

import io.miragon.example.application.port.in.sendmessage.SendMessageCommand;
import io.miragon.example.application.port.in.sendmessage.SendMessageUseCase;
import io.miragon.example.application.port.out.sendmessage.SendMessageOutCommand;
import io.miragon.example.application.port.out.sendmessage.SendMessagePort;
import io.miragon.miranum.connect.message.impl.MessageCorrelationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

public class SendMessageServiceTest {


    private SendMessageUseCase sendMessageService;

    @Mock
    private SendMessagePort sendMessagePort;

    @Captor
    private ArgumentCaptor<SendMessageOutCommand> sendMessageOutCommandArgumentCaptor;

    public SendMessageServiceTest() {
        MockitoAnnotations.openMocks(this);
        sendMessageService = new SendMessageService(sendMessagePort);
    }

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        sendMessageService = new SendMessageService(sendMessagePort);
    }

    @Test
    public void testSendMessage_Success() {
        String message = "my-message";
        String correlationKey = "my-correlation-key";
        Mockito.doNothing().when(sendMessagePort).sendMessage(Mockito.any());
        sendMessagePort.sendMessage(new SendMessageOutCommand(message, correlationKey, null));
        verify(sendMessagePort).sendMessage(sendMessageOutCommandArgumentCaptor.capture());
        SendMessageOutCommand capturedCommand = sendMessageOutCommandArgumentCaptor.getValue();
        assertEquals(message, capturedCommand.getMessageName());
        assertEquals(correlationKey, capturedCommand.getKey());
    }

    @Test
    public void testSendMessage_Failure() {
        String message = "my-message";
        String correlationKey = "my-correlation-key";
        Mockito.doThrow(MessageCorrelationException.class).when(sendMessagePort).sendMessage(Mockito.any());
        assertThrows(MessageCorrelationException.class, () ->
                sendMessageService.sendMessage(new SendMessageCommand(message, correlationKey, Map.of())));
        verify(sendMessagePort).sendMessage(sendMessageOutCommandArgumentCaptor.capture());
        SendMessageOutCommand capturedCommand = sendMessageOutCommandArgumentCaptor.getValue();
        assertEquals(message, capturedCommand.getMessageName());
        assertEquals(correlationKey, capturedCommand.getKey());
    }
}