package io.miragon.example.application.port.in.startprocess;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class InitiateProcessStartCommand {

    private String processKey;

    private Map<String, Object> data;
}