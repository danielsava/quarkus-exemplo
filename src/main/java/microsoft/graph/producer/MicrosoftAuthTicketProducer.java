package microsoft.graph.producer;

import com.azure.identity.ClientSecretCredential;
import com.azure.identity.ClientSecretCredentialBuilder;
import com.microsoft.graph.authentication.TokenCredentialAuthProvider;
import microsoft.graph.config.MicrosoftTicketConfig;
import microsoft.graph.producer.qualifiers.Ticket;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@ApplicationScoped
public class MicrosoftAuthTicketProducer {

    @Inject
    MicrosoftTicketConfig ticketConfig;

    @Produces
    @Ticket
    TokenCredentialAuthProvider tokenCredentialAuthProvider() {

        final ClientSecretCredential clientSecretCredential = new ClientSecretCredentialBuilder()
                .clientId(ticketConfig.client())
                .clientSecret(ticketConfig.secret())
                .tenantId(ticketConfig.tenant())
                .build();

        return new TokenCredentialAuthProvider(ticketConfig.scopes(), clientSecretCredential);
    }


}
