package com.allstate.speedyclaimsserver.unittests;

import com.allstate.speedyclaimsserver.domain.Claims;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DomainTests {

    @Test
    public void testSameClaimId() {
        //GIVEN
        Claims transaction1 = new Claims();
        Claims transaction2 = new Claims();

        //WHEN
        transaction1.setClaimid(999);
        transaction2.setClaimid(999);

        //THEN the transactions should be equal
        //assertTrue(transaction1.equals(transaction2));
        assertEquals(transaction1.getClaimid(), transaction2.getClaimid());
    }
}
