package microsoft.graph.config;

import io.smallrye.config.ConfigMapping;

import java.util.List;

@ConfigMapping(prefix = "microsoft.graph.app.ticket")
public interface MicrosoftTicketConfig {


    String tenant();

    String authority();

    String client();

    String secret();

    List<String> scopes();


}
