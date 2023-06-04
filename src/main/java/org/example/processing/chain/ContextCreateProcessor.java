package org.example.processing.chain;

import lombok.extern.slf4j.Slf4j;
import org.example.core.ChainFlowProcessor;
import org.example.processing.model.InteractionContext;
import org.example.processing.model.InteractionRequest;

@Slf4j
public class ContextCreateProcessor implements ChainFlowProcessor<InteractionRequest, InteractionContext> {

    @Override
    public void invoke(InteractionRequest input, Next<InteractionContext> next) {
        log.info("started creating context");

        InteractionContext context = new InteractionContext()
                .setChatId(input.getChatId())
                .setRequest(input);

        //TODO Other logic

        next.invoke(context);
    }
}
