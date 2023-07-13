package io.miragon.example.application.port.in;

public interface DoSomethingUseCase {

    DoSomethingResult doSomething(DoSomethingCommand command);
}
