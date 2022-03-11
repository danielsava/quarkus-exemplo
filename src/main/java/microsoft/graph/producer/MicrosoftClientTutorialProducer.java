package microsoft.graph.producer;

import com.microsoft.graph.authentication.TokenCredentialAuthProvider;
import com.microsoft.graph.logger.DefaultLogger;
import com.microsoft.graph.logger.LoggerLevel;
import com.microsoft.graph.requests.GraphServiceClient;
import microsoft.graph.producer.qualifiers.Tutorial;
import okhttp3.Request;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@ApplicationScoped
public class MicrosoftClientTutorialProducer {

    @Inject
    @Tutorial
    TokenCredentialAuthProvider authTutorial;

    // Build a Graph Client
    @Produces
    @Tutorial
    GraphServiceClient<Request> graphServiceClient() {

        // Create default logger to only log erros
        DefaultLogger logger = new DefaultLogger();
        logger.setLoggingLevel(LoggerLevel.ERROR);

        return GraphServiceClient
                .builder()
                .authenticationProvider(authTutorial)
                .logger(logger)
                .buildClient();

    }


}
