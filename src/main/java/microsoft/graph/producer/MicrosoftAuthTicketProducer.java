package microsoft.graph.producer;

import com.azure.identity.ClientSecretCredential;
import com.azure.identity.ClientSecretCredentialBuilder;
import com.azure.identity.DeviceCodeCredential;
import com.azure.identity.DeviceCodeCredentialBuilder;
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

    /* Credential: Secret */
    @Produces
    @Ticket
    TokenCredentialAuthProvider secretCredential() {

        final ClientSecretCredential clientSecretCredential = new ClientSecretCredentialBuilder()
                .clientId(ticketConfig.client())
                .clientSecret(ticketConfig.secret())
                .tenantId(ticketConfig.tenant())
                .build();

        return new TokenCredentialAuthProvider(ticketConfig.scopes(), clientSecretCredential);
    }

    /* Credential: Username Password
    @Produces
    @Ticket
    TokenCredentialAuthProvider usernamePasswordCredential() {
        final UsernamePasswordCredential usernamePasswordCredential = new UsernamePasswordCredentialBuilder()
                .clientId(ticketConfig.client())
                .username("c07d2e6e-45b2-43fd-9802-1cc8b1afeca0")
                .password("@Tcm012022")
                .build();

        return new TokenCredentialAuthProvider(ticketConfig.scopes(), usernamePasswordCredential);
    }
    */


    /* Credential: Device Code
    @Produces
    @Ticket
    TokenCredentialAuthProvider deviceCodeCredential() {

        final DeviceCodeCredential credential = new DeviceCodeCredentialBuilder()
                .clientId(ticketConfig.client())
                .challengeConsumer(challenge -> System.out.println(challenge.getMessage()))
                .build();

        return new TokenCredentialAuthProvider(ticketConfig.scopes(), credential);
    }

    */



}
