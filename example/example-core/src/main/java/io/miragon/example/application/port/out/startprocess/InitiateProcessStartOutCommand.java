package io.miragon.example.application.port.out.startprocess;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class InitiateProcessStartOutCommand {

    private String processKey;

    private Map<String, Object> data;
}