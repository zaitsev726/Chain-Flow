package org.example.processing.chain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.core.ChainFlowProcessor;
import org.example.processing.model.InteractionContext;
import org.example.processing.service.CommandExecutor;

@Slf4j
@RequiredArgsConstructor
public class CommandExecutionProcessor implements ChainFlowProcessor<InteractionContext, InteractionContext> {
    private final CommandExecutor<InteractionContext> commandExecutor;

    @Override
    public void invoke(InteractionContext input, Next<InteractionContext> next) {
        log.info("started command execution processor");

        var result = commandExecutor.getAndExecuteCommand(input);

        input.setServerActivity(result);

        next.invoke(input);
    }

}
