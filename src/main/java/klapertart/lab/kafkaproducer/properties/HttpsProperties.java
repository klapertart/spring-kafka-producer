package klapertart.lab.kafkaproducer.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author kurakuraninja
 * @since 21/02/23
 */

@Component
@ConfigurationProperties("server.ssl")
@Getter
@Setter
public class HttpsProperties {
    private boolean enabled;
    private String keyStore;
    private String keyStorePassword;
    private String keyStoreType;
    private String keyAlias;
    private String enabledProtocols;
}
