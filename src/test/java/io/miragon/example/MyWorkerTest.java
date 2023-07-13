package io.miragon.example;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class MyWorkerTest {

    @Test
    public void testDoSomething() {
        MyWorker myWorker = new MyWorker();

        var doSomethingCommand = new MyWorker.DoSomethingCommand("test");
        var expectedDoSomethingResult = new MyWorker.DoSomethingResult("test result");

        MyWorker.DoSomethingResult actualDoSomethingResult = myWorker.doSomething(doSomethingCommand);

        assertEquals(expectedDoSomethingResult.getResult(), actualDoSomethingResult.getResult());
    }
}