package io.miragon.example.application.port.out.startprocess;

import java.util.Map;

public interface InitiateProcessStartPort {

    void initiateProcessStart(final InitiateProcessStartOutCommand command);
}