package org.example.processing.chain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.core.ChainFlowProcessor;
import org.example.processing.model.InteractionContext;
import org.example.processing.service.TelegramSessionService;

@Slf4j
@RequiredArgsConstructor
public class TelegramSessionRestoreProcessor implements ChainFlowProcessor<InteractionContext, InteractionContext> {
    private final TelegramSessionService sessionService;

    @Override
    public void invoke(InteractionContext input, Next<InteractionContext> next) {
        log.info("started restoring session");

        sessionService.getSession(input.getChatId())
                .ifPresent(session -> input.setSessionId(session.getId().toString()));

        next.invoke(input);
    }
}
