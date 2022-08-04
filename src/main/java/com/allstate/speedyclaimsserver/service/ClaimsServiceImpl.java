package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.data.ClaimsRespository;
import com.allstate.speedyclaimsserver.domain.Claims;
import com.allstate.speedyclaimsserver.exceptions.TransactionNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaimsServiceImpl implements ClaimsService {
    @Autowired
    private ClaimsRespository claimsRespository;

    Logger logger = LoggerFactory.getLogger(ClaimsService.class);

    @Override
    public List<Claims> getAllTransactions() {
        return claimsRespository.findAll();
    }

    @Override
    public int countTransactions() {
        return claimsRespository.findAll().size();
    }

    @Override
    public List<Claims> getAllTransactionsForCustlname(String custlname) {

        return claimsRespository.findAllByCustlname(custlname);
    }

    @Override
    public List<Claims> getAllTransactionsForPolicynumber(Integer policynumber) {
        return claimsRespository.findAllByPolicynumber(policynumber);
    }

    @Override
    public Claims getTransactionByClaimId(Integer claimid) {
        Optional<Claims> optionalCCT =  claimsRespository.findById(claimid);
        if (optionalCCT.isPresent()) {
            return optionalCCT.get();
        }
        logger.info("There is no transaction with a claimid of " + claimid);
        throw new TransactionNotFoundException("There is no transaction with a claimid of " + claimid);
    }


}
