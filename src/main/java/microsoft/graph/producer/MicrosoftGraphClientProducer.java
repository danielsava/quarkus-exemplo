package microsoft.graph.producer;

import com.microsoft.graph.authentication.TokenCredentialAuthProvider;
import com.microsoft.graph.logger.DefaultLogger;
import com.microsoft.graph.logger.LoggerLevel;
import com.microsoft.graph.requests.GraphServiceClient;
import okhttp3.Request;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@ApplicationScoped
public class MicrosoftGraphClientProducer {

    @Inject
    TokenCredentialAuthProvider authProvider;

    // Build a Graph Client
    @Produces
    GraphServiceClient<Request> graphServiceClient() {

        // Create default logger to only log erros
        DefaultLogger logger = new DefaultLogger();
        logger.setLoggingLevel(LoggerLevel.ERROR);

        return GraphServiceClient.builder()
                .authenticationProvider(authProvider)
                .logger(logger)
                .buildClient();

    }


}
