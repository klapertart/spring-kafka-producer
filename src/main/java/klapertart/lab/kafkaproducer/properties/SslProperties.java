package klapertart.lab.kafkaproducer.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author kurakuraninja
 * @since 20/02/23
 */

@ConfigurationProperties("ssl")
@Component
@Getter
@Setter
public class SslProperties {
    private String enabled;
    private String jaasUsername;
    private String jaasPassword;
    private String keyPassword;
    private String truststoreLocation;
    private String truststorePassword;
    private String keystoreLocation;
    private String keystorePassword;
}
