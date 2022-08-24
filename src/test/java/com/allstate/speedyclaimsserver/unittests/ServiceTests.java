package com.allstate.speedyclaimsserver.unittests;


import com.allstate.speedyclaimsserver.data.ClaimsRespository;
import com.allstate.speedyclaimsserver.domain.Claims;
import com.allstate.speedyclaimsserver.service.ClaimsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})
public class ServiceTests {

    @Autowired
    ClaimsService claimsService;

    @MockBean
    ClaimsRespository claimsRespository;

    @Test
    public void testTransactionByClaimId() {
        Claims transaction = new Claims();
        transaction = (new Claims(999,1234,"Open","Home", "Test Fname", "Test Lname", LocalDate.now(), 0.00, "", "", LocalDate.now(), "", "111 abc Road", "", "", "", "", ""));

        Mockito.when(claimsRespository.findById(999)).thenReturn(Optional.of(transaction));

        Claims result = claimsService.getTransactionByClaimId(((Claims) transaction).getClaimid());
        assertEquals(999, result.getClaimid());
    }

}
