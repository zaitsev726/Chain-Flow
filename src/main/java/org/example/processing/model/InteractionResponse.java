package org.example.processing.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class InteractionResponse {

    private String chatId;
    private String messageId;
    private SendOption sendOption;
    private Object data;
}
