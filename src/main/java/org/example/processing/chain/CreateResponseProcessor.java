package org.example.processing.chain;

import lombok.extern.slf4j.Slf4j;
import org.example.core.ChainFlowProcessor;
import org.example.processing.model.InteractionContext;
import org.example.processing.model.InteractionResponse;
import org.example.processing.model.SendOption;
import org.example.processing.model.activity.ServerActivity;

@Slf4j
public class CreateResponseProcessor implements ChainFlowProcessor<InteractionContext, InteractionResponse> {

    @Override
    public void invoke(InteractionContext input, Next<InteractionResponse> next) {
        var request = input.getRequest();
        var serverResponse = input.getServerActivity();

        var response = new InteractionResponse()
                .setChatId(request.getChatId())
                .setMessageId(request.getMessageId())
                .setSendOption(SendOption.NEW);

        if (serverResponse.getStatus() == ServerActivity.Status.FAIL) {
            log.info("successfully created failed response");
            next.invoke(response);
            return;
        }

        response.setData(serverResponse.getData());
        next.invoke(response);
    }
}
