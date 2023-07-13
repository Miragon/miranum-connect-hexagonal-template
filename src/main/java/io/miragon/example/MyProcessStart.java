package io.miragon.example;

import io.miragon.miranum.connect.process.api.StartProcessCommand;
import io.miragon.miranum.connect.process.impl.StartProcessPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class MyProcessStart {

    private final StartProcessPort startProcessPort;

    public void startProcess(final String processKey) {
        log.info("Starting process: " + processKey);
        var command = new StartProcessCommand(processKey, null);
        startProcessPort.startProcess(command);
        log.info("Started process: " + processKey + ".");
    }
}