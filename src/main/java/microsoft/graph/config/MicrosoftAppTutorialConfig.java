package microsoft.graph.config;

import io.smallrye.config.ConfigMapping;

import java.util.List;

@ConfigMapping(prefix = "microsoft.graph.app.tutorial")
public interface MicrosoftAppTutorialConfig {


    /*
    Overriding Property Names
    @WithName("name")
    String host();
    */


    String id();

    List<String> scopes();


}
