package org.example.processing.service;

import org.example.processing.model.TelegramSession;

import java.util.Optional;

public interface TelegramSessionService {
    Optional<TelegramSession> getSession(String chatId);
}
