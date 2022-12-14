package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.domain.Claims;
import com.allstate.speedyclaimsserver.dtos.ClaimsDTO;

import java.util.List;
import java.util.Map;

public interface ClaimsService {
    List<Claims> getAllTransactions();
    int countTransactions();
    List<Claims> getAllTransactionsForCustlname(String custlname);
    List<Claims> getAllTransactionsForPolicynumber(Integer policynumber);
    Claims getTransactionByClaimId(Integer claimid);
    List<Claims> getAllTransactionsForStatus(String status);

    Claims add(ClaimsDTO transaction);
    Claims updateTransaction(Integer id, Map<String,String> data);
}
