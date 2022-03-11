package microsoft.graph.rest;

import com.azure.identity.ClientSecretCredential;
import com.azure.identity.ClientSecretCredentialBuilder;
import com.azure.identity.UsernamePasswordCredential;
import com.azure.identity.UsernamePasswordCredentialBuilder;
import com.microsoft.graph.authentication.TokenCredentialAuthProvider;
import com.microsoft.graph.logger.DefaultLogger;
import com.microsoft.graph.logger.LoggerLevel;
import com.microsoft.graph.models.User;
import com.microsoft.graph.requests.GraphServiceClient;
import microsoft.graph.config.MicrosoftTicketConfig;
import microsoft.graph.model.UserInfo;
import microsoft.graph.service.MicrosoftTicketService;
import okhttp3.Request;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/microsoft/ticket")
public class MicrosoftTicketRest {


    @Inject
    MicrosoftTicketService ticketService;

    @Inject
    MicrosoftTicketConfig ticketConfig;

    @GET
    @Path("/me")
    public UserInfo teste() {

        ClientSecretCredential clientSecretCredential = new ClientSecretCredentialBuilder()
                .clientId(ticketConfig.client())
                .clientSecret(ticketConfig.secret())
                .tenantId(ticketConfig.tenant())
                .build();

        TokenCredentialAuthProvider tokenClientSecret = new TokenCredentialAuthProvider(ticketConfig.scopes(), clientSecretCredential);


        final UsernamePasswordCredential usernamePasswordCredential = new UsernamePasswordCredentialBuilder()
                .clientId(ticketConfig.client())
                .username("c07d2e6e-45b2-43fd-9802-1cc8b1afeca0")
                .password("@Tcm012022")
                .build();

        TokenCredentialAuthProvider tokenUserPassword = new TokenCredentialAuthProvider(ticketConfig.scopes(), usernamePasswordCredential);


        DefaultLogger logger = new DefaultLogger();
        logger.setLoggingLevel(LoggerLevel.DEBUG);

        GraphServiceClient<Request> graphClient = GraphServiceClient
                .builder()
                .authenticationProvider(tokenUserPassword)
                .logger(logger)
                .buildClient();


        /*
        ChatMessage chatMessage = new ChatMessage();
        ItemBody body = new ItemBody();
        body.content = "Ticket Teste ...";
        chatMessage.body = body;

        graphClient.teams("2362f840-9a4e-4abc-b8d7-7e4176e1eca0").channels("19%3a7df86b2319b8416a8eb20def9c3b452f%40thread.tacv2").messages()
                .buildRequest()
                .post(chatMessage);
        */

        /* */
        User user = graphClient.users("c07d2e6e-45b2-43fd-9802-1cc8b1afeca0").
                buildRequest()
                //.select("displayName")
                .get();

        UserInfo userInfo = new UserInfo();
        userInfo.aboutMe = "Teste Ticket App";
        userInfo.displayName = user.displayName;


        return new UserInfo();

    }





    public UserInfo infoMe() {

        User user = ticketService.userInfo();

        UserInfo userInfo = new UserInfo();
        userInfo.aboutMe = "Teste Ticket App";
        userInfo.displayName = user.displayName;

        return userInfo;
    }

}

