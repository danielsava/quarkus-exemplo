package microsoft.graph.service;


import com.microsoft.graph.authentication.TokenCredentialAuthProvider;
import com.microsoft.graph.models.User;
import com.microsoft.graph.requests.GraphServiceClient;
import microsoft.graph.producer.qualifiers.Tutorial;
import okhttp3.Request;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.net.URL;

@ApplicationScoped
public class MicrosoftTutorialService {

    @Inject
    Logger log;

    @Inject @Tutorial
    TokenCredentialAuthProvider authProviderAppTutorial;

    @Inject @Tutorial
    GraphServiceClient<Request> graphClientAppTutorial;



    public String userAccessToken() {

        try {

            URL meURL = new URL("https://graph.microsoft.com/v1.0/me");
            return authProviderAppTutorial.getAuthorizationTokenAsync(meURL).get();

        } catch (Exception e) {
            log.error("Erro ao gerar UserAccessToken", e);
            throw new RuntimeException(e);
        }

    }

    public User userInfo() {
        return graphClientAppTutorial.
                me().
                buildRequest()
                .select("displayName")
                .get();
    }


}
