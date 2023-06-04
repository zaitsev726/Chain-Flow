package org.example.processing.chain;


import org.example.core.ChainFlowProcessor;
import org.example.processing.model.InteractionContext;
import org.example.processing.model.InteractionRequest;
import org.example.processing.model.InteractionResponse;
import org.example.processing.model.activity.ServerActivity;
import org.example.processing.model.activity.ServerProactivity;

public class DefaultChains {

    public static ChainFlowProcessor<InteractionRequest, InteractionResponse> getUserInteractionProcessor(
            ChainFlowProcessor<InteractionContext, InteractionContext> customChain
    ) {
        return new LoggingProcessor<InteractionRequest>()
                .chain(new RequestValidationProcessor())
                .chain(new ContextCreateProcessor())
                .chain(customChain)
                .chain(new CommandExecutionProcessor(null))
                .chain(new CreateResponseProcessor());
    }

    public static ChainFlowProcessor<ServerProactivity, ServerActivity> getProactivityProcessor() {
        return null; //TODO Add chain to send pro active events
    }
}
