package microsoft.graph.producer;

import com.microsoft.graph.authentication.TokenCredentialAuthProvider;
import com.microsoft.graph.logger.DefaultLogger;
import com.microsoft.graph.logger.LoggerLevel;
import com.microsoft.graph.requests.GraphServiceClient;
import microsoft.graph.producer.qualifiers.Ticket;
import okhttp3.Request;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@ApplicationScoped
public class MicrosoftClientTicketProducer {

    @Inject
    @Ticket
    TokenCredentialAuthProvider ticketAuth;

    @Produces
    @Ticket
    GraphServiceClient<Request> clientTicket() {

        DefaultLogger logger = new DefaultLogger();
        logger.setLoggingLevel(LoggerLevel.ERROR);

        return GraphServiceClient
                .builder()
                .authenticationProvider(ticketAuth)
                .logger(logger)
                .buildClient();

    }


    /*
    @Produces
    AppTicketToken appTicketToken() {

        try {

            ConfidentialClientApplication appClient = confidentialClientApplication();

            IAuthenticationResult result = authentication(appClient);

            return AppTicketToken.of(result.accessToken());

        } catch (Exception e) {

            log.error("Erro ao gerar AppTicketToken", e);
            throw new RuntimeException(e);
        }

    }

    private ConfidentialClientApplication confidentialClientApplication() throws MalformedURLException {

        return ConfidentialClientApplication
                .builder(
                        ticketConfig.client(),
                        ClientCredentialFactory.createFromSecret(ticketConfig.secret())
                )
                .authority(ticketConfig.authority())
                .build();

    }

    private IAuthenticationResult authentication(ConfidentialClientApplication app) throws ExecutionException, InterruptedException {

        // With client credentials flows the scope is ALWAYS of the shape "resource/.default", as the
        // application permissions need to be set statically (in the portal), and then granted by a tenant administrator
        ClientCredentialParameters clientCredentialParam = ClientCredentialParameters
                .builder(
                    Collections.singleton(ticketConfig.scope()))
                .build();

        CompletableFuture<IAuthenticationResult> future = app.acquireToken(clientCredentialParam);

        return future.get();
    }
    */

}
