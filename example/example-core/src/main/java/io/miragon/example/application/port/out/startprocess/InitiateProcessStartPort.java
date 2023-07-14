package io.miragon.example.application.port.out.startprocess;

public interface InitiateProcessStartPort {

    void initiateProcessStart(final InitiateProcessStartOutCommand command);
}