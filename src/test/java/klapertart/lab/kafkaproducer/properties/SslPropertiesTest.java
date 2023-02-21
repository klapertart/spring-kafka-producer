package klapertart.lab.kafkaproducer.properties;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author kurakuraninja
 * @since 21/02/23
 */

@SpringBootTest
@Slf4j
public class SslPropertiesTest {

    @Autowired
    private SslProperties sslProperties;

    @Test
    void testPrintClass() {
        log.info("##### SSL CONFIG : {}",sslProperties.toString());
    }
}
