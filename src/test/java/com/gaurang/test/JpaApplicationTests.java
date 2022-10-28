package com.gaurang.test;

import static org.assertj.core.api.Assertions.assertThat;

import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.flywaydb.test.annotation.FlywayTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureEmbeddedDatabase
@FlywayTest
class JpaApplicationTests {

    @Test
    void contextLoads() {
        var bool = true;
        assertThat(bool).isTrue();
    }

}
