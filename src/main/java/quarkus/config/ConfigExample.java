package quarkus.config;

import io.quarkus.logging.Log;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ConfigExample {

    @Inject
    ServerConfig serverConfig;

    public void valores() {
        Log.info("Config Example: " + serverConfig.host() + ", " + serverConfig.port() + ", " + serverConfig.thePort());
    }


}
