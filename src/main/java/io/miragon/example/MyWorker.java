package io.miragon.example;

import io.miragon.miranum.connect.worker.api.Worker;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyWorker {

    @Worker(type = "my-type")
    public DoSomethingResult doSomething(DoSomethingCommand doSomethingCommand) {
        log.info("Received command: " + doSomethingCommand);
        var result = doSomethingCommand.getCommand() + " result";
        log.info("Returning result: " + result);
        return new DoSomethingResult(result);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    static class DoSomethingCommand {
        private String command;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    static class DoSomethingResult {
        private String result;
    }
}