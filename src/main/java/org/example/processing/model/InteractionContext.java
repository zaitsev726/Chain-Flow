package org.example.processing.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.example.processing.model.activity.ServerActivity;
import org.example.processing.model.activity.UserActivity;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public final class InteractionContext {

    private UUID stateId;

    private String payload;

    private String userId;

    private String sessionId;

    private String chatId;

    private InteractionRequest request;

    private InteractionResponse response;

    private UserActivity userActivity;

    private ServerActivity serverActivity;
}
