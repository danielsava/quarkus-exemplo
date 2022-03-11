package microsoft.graph;


import com.microsoft.graph.authentication.TokenCredentialAuthProvider;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.net.URL;

@ApplicationScoped
public class MicrosoftGraphTutorialService {

    private static final Logger log = Logger.getLogger(MicrosoftGraphTutorialService.class);

    @Inject
    TokenCredentialAuthProvider authProvider;

    public String userAccessToken() {

        try {

            URL meURL = new URL("https://graph.microsoft.com/v1.0/me");
            return authProvider.getAuthorizationTokenAsync(meURL).get();

        } catch (Exception e) {
            log.error("Erro ao gerar UserAccessToken", e);
            throw new RuntimeException(e);
        }

    }



}
