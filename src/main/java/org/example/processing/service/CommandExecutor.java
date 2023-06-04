package org.example.processing.service;


import org.example.processing.model.activity.ServerActivity;

public interface CommandExecutor<T> {
    ServerActivity getAndExecuteCommand(T input);
}
