package quarkus.config;

import io.smallrye.config.ConfigMapping;


/**
 *
 *      Documentação:
 *          - https://quarkus.io/guides/config-mappings
 *
 */

@ConfigMapping(prefix = "examplo.config.server")
public interface ServerConfig {

    String host();

    int port();

    int thePort();

}
