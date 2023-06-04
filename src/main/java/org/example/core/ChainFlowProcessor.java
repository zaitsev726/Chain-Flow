package org.example.core;

@FunctionalInterface
public interface ChainFlowProcessor<CURRENT_INPUT, CURRENT_RESPONSE> {

    void invoke(CURRENT_INPUT input, Next<CURRENT_RESPONSE> next);

    default <NEXT_RESPONSE> ChainFlowProcessor<CURRENT_INPUT, NEXT_RESPONSE> chain(
            ChainFlowProcessor<CURRENT_RESPONSE, NEXT_RESPONSE> source
    ) {
        return (value, nextR) -> ChainFlowProcessor.this.invoke(value, input -> source.invoke(input, nextR));
    }

    interface Next<T> {
        void invoke(T input);
    }
}
