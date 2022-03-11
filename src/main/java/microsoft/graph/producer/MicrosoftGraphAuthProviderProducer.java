package microsoft.graph.producer;

import com.azure.identity.DeviceCodeCredential;
import com.azure.identity.DeviceCodeCredentialBuilder;
import com.microsoft.graph.authentication.TokenCredentialAuthProvider;
import microsoft.graph.config.MicrosoftAppTutorialConfig;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class MicrosoftGraphAuthProviderProducer {

    @Inject
    MicrosoftAppTutorialConfig appTutorialConfig;

    // Create the auth provider
    @Produces
    TokenCredentialAuthProvider tokenCredentialAuthProvider() {

        String applicationId = appTutorialConfig.id();
        List<String> scopes = appTutorialConfig.scopes();

        DeviceCodeCredential credential = new DeviceCodeCredentialBuilder()
                .clientId(applicationId)
                .challengeConsumer(challenge -> System.out.println(challenge.getMessage()))
                .build();

        return new TokenCredentialAuthProvider(scopes, credential);
    }


}
