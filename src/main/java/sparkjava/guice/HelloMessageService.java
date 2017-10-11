package sparkjava.guice;

import com.google.inject.Singleton;

import java.time.LocalDateTime;

@Singleton
public class HelloMessageService {

    public HelloMessage sayHello() {
        return new HelloMessage("Hello spark!", LocalDateTime.now());
    }
}
