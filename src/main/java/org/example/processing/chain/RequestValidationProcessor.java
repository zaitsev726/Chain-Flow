package org.example.processing.chain;

import lombok.extern.slf4j.Slf4j;
import org.example.core.ChainFlowProcessor;
import org.example.processing.exception.ValidationException;
import org.example.processing.model.InteractionRequest;

import static com.google.common.base.Strings.isNullOrEmpty;


@Slf4j
public class RequestValidationProcessor implements ChainFlowProcessor<InteractionRequest, InteractionRequest> {

    @Override
    public void invoke(InteractionRequest input, Next<InteractionRequest> next) {
        log.info("started with input {}", input);

        validateInputRequest(input);

        next.invoke(input);
    }

    private void validateInputRequest(InteractionRequest input) {
        if (isNullOrEmpty(input.getChatId())) {
            log.error("chat id is null or empty");
            throw new ValidationException("Chat id is null or empty");
        }

        if (isNullOrEmpty(input.getMessageId())) {
            log.error("message id is null or empty");
            throw new ValidationException("Message id is null or empty");
        }

        if (isNullOrEmpty(input.getText()) && isNullOrEmpty(input.getButtonId())) {
            log.error("payload is null or empty");
            throw new ValidationException("Payload is null or empty");
        }

    }
}
