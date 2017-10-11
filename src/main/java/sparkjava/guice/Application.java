package sparkjava.guice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Guice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import static spark.Spark.*;

public class Application {

    private final static Logger LOG = LoggerFactory.getLogger(Application.class.getCanonicalName());

    private final HelloMessageService helloMessageService;
    private final ObjectMapper objectMapper;

    @Inject
    Application(final HelloMessageService helloMessageService, final ObjectMapper objectMapper) {
        this.helloMessageService = helloMessageService;
        this.objectMapper = objectMapper;
    }

    void run(final int port) {
        port(port);

        before("/*", (req, res) -> LOG.info(String.format("%s: %s", req.requestMethod(), req.uri())));

        get("/", (req, res) -> {
            final HelloMessage message = helloMessageService.sayHello();
            return objectMapper.writeValueAsString(message);
        });

        after("/*", (req, res) -> LOG.info(res.body()));
    }

    public static void main(final String... args) {
        Guice.createInjector(new GuiceModule())
                .getInstance(Application.class)
                .run(9999);
    }
}
