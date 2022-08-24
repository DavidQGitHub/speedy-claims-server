package com.allstate.speedyclaimsserver.unittests;

import com.allstate.speedyclaimsserver.control.ClaimsController;
import com.allstate.speedyclaimsserver.domain.Claims;
import com.allstate.speedyclaimsserver.dtos.ClaimsDTO;
import com.allstate.speedyclaimsserver.service.ClaimsService;
import org.junit.jupiter.api.BeforeEach;
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

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})
public class ControllerTests {

    @Autowired
    ClaimsController claimsController;

    @MockBean
    ClaimsService claimsService;

    @Test
    public void testAddTransaction() {
        Claims newClaimTransaction = new Claims();
        newClaimTransaction = (new Claims(null,1234,"Open","Home", "Test Fname", "Test Lname", LocalDate.now(), 0.00, "", "", LocalDate.now(), "", "111 abc Road", "", "", "", "", ""));

        ClaimsDTO dtoTransaction = new ClaimsDTO();
        dtoTransaction = new ClaimsDTO(newClaimTransaction);

        Claims claimsTransaction = new Claims();
        claimsTransaction = (new Claims(999,1234,"Open","Home", "Test Fname", "Test Lname", LocalDate.now(), 0.00, "", "", LocalDate.now(), "", "111 abc Road", "", "", "", "", ""));

        Mockito.when(claimsService.add(dtoTransaction))
                .thenReturn(claimsTransaction);

        Claims result = claimsController.addTransaction(dtoTransaction);
        assertEquals(999, result.getClaimid());
    }

}
