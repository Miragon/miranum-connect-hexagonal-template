package io.miragon.example.adapter.in.miranum;

import io.miragon.example.application.port.in.dosomething.DoSomethingCommand;
import io.miragon.example.application.port.in.dosomething.DoSomethingResult;
import io.miragon.example.application.port.in.dosomething.DoSomethingUseCase;
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