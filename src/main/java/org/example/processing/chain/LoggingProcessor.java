package org.example.processing.chain;

import lombok.extern.slf4j.Slf4j;
import org.example.core.ChainFlowProcessor;

@Slf4j
public class LoggingProcessor<T>  implements ChainFlowProcessor<T, T> {

    @Override
    public void invoke(T input, Next<T> next) {
        log.info("started with input class {}", input.getClass());
        next.invoke(input);
    }
}
