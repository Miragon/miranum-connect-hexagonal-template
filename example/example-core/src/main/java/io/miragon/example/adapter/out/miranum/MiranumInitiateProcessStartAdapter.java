package io.miragon.example.adapter.out.miranum;

import io.miragon.example.application.port.out.startprocess.InitiateProcessStartOutCommand;
import io.miragon.example.application.port.out.startprocess.InitiateProcessStartPort;
import io.miragon.miranum.connect.process.api.StartProcessCommand;
import io.miragon.miranum.connect.process.impl.StartProcessPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MiranumInitiateProcessStartAdapter implements InitiateProcessStartPort {

    private final StartProcessPort startProcessPort;

    @Override
    public void initiateProcessStart(InitiateProcessStartOutCommand command) {
        var startProcessCommand = new StartProcessCommand(command.getProcessKey(), command.getData());
        startProcessPort.startProcess(startProcessCommand);
    }
}