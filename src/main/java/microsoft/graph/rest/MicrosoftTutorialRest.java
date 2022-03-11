package microsoft.graph.rest;

import com.microsoft.graph.models.User;
import io.quarkus.logging.Log;
import microsoft.graph.model.UserInfo;
import microsoft.graph.service.MicrosoftTutorialService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/microsoft/tutorial")
public class MicrosoftTutorialRest {


    @Inject
    MicrosoftTutorialService tutorialService;


    @GET
    @Path("/token")
    public String userAccessToken() {

        String token = tutorialService.userAccessToken();
        Log.info("Tutorial UserAccessToken: " + token);
        return token;
    }

    @GET
    @Path("/me")
    public UserInfo infoMe() {

        User user = tutorialService.userInfo();

        UserInfo userInfo = new UserInfo();
        userInfo.aboutMe = "Teste Tutorial";
        userInfo.displayName = user.displayName;

        return userInfo;
    }




}

