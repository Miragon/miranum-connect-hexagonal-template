package io.miragon.example.adapter.in.miranum;

import io.miragon.example.application.port.in.DoSomethingCommand;
import io.miragon.example.application.port.in.DoSomethingResult;
import io.miragon.example.application.port.in.DoSomethingUseCase;
import io.miragon.miranum.connect.worker.api.Worker;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MiranumWorkerAdapter {

    private final DoSomethingUseCase doSomethingUseCase;

    @Worker(type = "my-type")
    public DoSomethingResult doSomething(DoSomethingCommand command) {
        return doSomethingUseCase.doSomething(command);
    }
}