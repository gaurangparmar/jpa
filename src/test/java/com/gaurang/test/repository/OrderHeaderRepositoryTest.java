package com.gaurang.test.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.gaurang.test.entity.OrderHeader;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import javax.persistence.EntityManager;
import java.time.LocalDate;

@DataJpaTest
@AutoConfigureEmbeddedDatabase
@Sql("/testsetup/sql/insert_prerequisite_records.sql")
public class OrderHeaderRepositoryTest {

    @Autowired
    private OrderHeaderRepository repository;

    @Test
    void findPendingOrdersToCancel() {
        String orderId = "a19572647";
        var ordHdr = repository.findByOrderId(orderId).get();
        ordHdr.setDeliveryDate(LocalDate.now());
        repository.saveAndFlush(ordHdr);
    }
}
