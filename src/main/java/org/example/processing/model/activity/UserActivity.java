package org.example.processing.model.activity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class UserActivity extends Activity {

    private Type type;

    public enum Type {
        START,
        PRESSED_BUTTON,
        TEXT,
        END
    }
}
