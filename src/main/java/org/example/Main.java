package org.example;

import org.example.processing.chain.DefaultChains;
import org.example.processing.chain.TelegramSessionRestoreProcessor;
import org.example.processing.model.InteractionRequest;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public void startChain(InteractionRequest request) {
        DefaultChains
                .getUserInteractionProcessor(new TelegramSessionRestoreProcessor(chatId -> Optional.empty()))
                .invoke(request, response -> {
                    //send it to kafka, or smth else
                });
    }
}