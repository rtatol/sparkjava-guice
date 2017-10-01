package sparkjava.guice;

import java.time.LocalDateTime;

public class HelloMessage {

    private final String message;
    private final LocalDateTime dateTime;

    public HelloMessage(final String message, final LocalDateTime dateTime) {
        this.message = message;
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
