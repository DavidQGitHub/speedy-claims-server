package com.allstate.speedyclaimsserver.unittests;

import com.allstate.speedyclaimsserver.data.ClaimsRespository;
import com.allstate.speedyclaimsserver.domain.Claims;
import com.allstate.speedyclaimsserver.dtos.ClaimsDTO;
import com.allstate.speedyclaimsserver.exceptions.InvalidNewTransactionException;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})
public class ServiceTests {

    @Autowired
    ClaimsService claimsService;

    @MockBean
    ClaimsRespository claimsRespository;

    Claims transaction = new Claims();

    @BeforeEach
    public void setup() {
        transaction = (new Claims(999,1234,"Open","Home", "Test Fname", "Test Lname", LocalDate.now(), 0.00, "", "", LocalDate.now(), "", "111 abc Road", "", "", "", "", ""));

        Mockito.when(claimsRespository.findById(999)).thenReturn(Optional.of(transaction));
    }

    // test retrieving transaction by claim id
    @Test
    public void testTransactionByClaimId() {
        Claims result = claimsService.getTransactionByClaimId(((Claims) transaction).getClaimid());
        assertEquals(999, result.getClaimid());
    }

    // test update claim status to rejected
    @Test
    public void testUpdateTransaction(){
        Mockito.when(claimsRespository.save(transaction)).thenReturn(transaction);

        HashMap<String,String> m = new HashMap<String,String>();
        m.put("status","Rejected");
        Claims result = claimsService.updateTransaction(999, m);
        assertEquals("Rejected", result.getStatus());
    }

    // test add new claim with a blank policy number
    @Test
    public void testAdd(){
        Claims newClaimTransaction = new Claims();
        newClaimTransaction = (new Claims(null, null,"Open","Home", "Test Fname", "Test Lname", LocalDate.now(), 0.00, "", "", LocalDate.now(), "", "111 abc Road", "", "", "", "", ""));

        ClaimsDTO dtoTransaction = new ClaimsDTO();
        dtoTransaction = new ClaimsDTO(newClaimTransaction);

        ClaimsDTO finalDtoTransaction = dtoTransaction;
        InvalidNewTransactionException thrown = assertThrows(
                InvalidNewTransactionException.class, () -> claimsService.add(finalDtoTransaction));

        System.out.println("Result from add : " + thrown);
        assertTrue(thrown.getMessage().contains("Policy number must be provided"));
    }

}
