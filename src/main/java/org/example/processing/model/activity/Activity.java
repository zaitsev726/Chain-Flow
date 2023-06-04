package org.example.processing.model.activity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class Activity {

    private String chatId;
    private String messageId;
    private String content;
}
