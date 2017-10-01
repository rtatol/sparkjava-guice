package sparkjava.guice;

import java.time.LocalDateTime;

public class HelloMessageService {

    public HelloMessage sayHello() {
        return new HelloMessage("Hello spark!", LocalDateTime.now());
    }
}
