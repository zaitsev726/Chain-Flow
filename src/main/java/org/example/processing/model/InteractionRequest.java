package org.example.processing.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@ToString
public class InteractionRequest {
    private String chatId;

    private String messageId;

    private String buttonId;

    private String text;
}
