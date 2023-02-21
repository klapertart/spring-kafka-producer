package klapertart.lab.kafkaproducer.properties;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author kurakuraninja
 * @since 21/02/23
 */

@SpringBootTest
@Slf4j
public class HttpsPropertiesTest {

    @Autowired
    private HttpsProperties httpsProperties;


    @Test
    void testPrintClass() {
        log.info("##### HTTPS CONFIG : {}",httpsProperties.toString());
    }
}
