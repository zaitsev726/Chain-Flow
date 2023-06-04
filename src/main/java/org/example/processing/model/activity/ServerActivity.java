package org.example.processing.model.activity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(chain = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ServerActivity extends Activity {
    private Status status;
    private Type type;
    private Object data;

    public static ServerActivity success(Type type, Object data) {
        return new ServerActivity(Status.SUCCESS, type, data);
    }

    public static ServerActivity fail() {
        return new ServerActivity(Status.FAIL, null, null);
    }

    public enum Status {
        SUCCESS,
        FAIL
    }

    public enum Type {
        RERENDER,
        RENDER,
        NOTHING,
        CHANGE_PAGE
    }
}
