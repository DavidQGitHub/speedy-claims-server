package com.allstate.speedyclaimsserver.service;

import com.allstate.speedyclaimsserver.data.ClaimsRespository;
import com.allstate.speedyclaimsserver.domain.Claims;
import com.allstate.speedyclaimsserver.dtos.ClaimsDTO;
import com.allstate.speedyclaimsserver.exceptions.InvalidNewTransactionException;
import com.allstate.speedyclaimsserver.exceptions.TransactionNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
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
    public List<Claims> getAllTransactionsForStatus(String status) {

        return claimsRespository.findAllByStatus(status);
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


    @Override
    public Claims add(ClaimsDTO transactionDTO) {
        Claims transaction = transactionDTO.toClaims();

        if(transaction.getPolicynumber() == null ) {
            throw new InvalidNewTransactionException("Policy number must be provided");
        }
        try {
            return claimsRespository.save(transaction);
        }
        catch (Exception e) {
            throw new InvalidNewTransactionException("Unable to save your transaction");
        }
    }

    @Override
    public Claims updateTransaction(Integer id, Map<String, String> data) {
        Claims transaction = getTransactionByClaimId(id);
        if (data.containsKey("policynumber")) transaction.setPolicynumber(Integer.parseInt(data.get("policynumber")));
        if (data.containsKey("status")) transaction.setStatus(data.get("status"));
        if (data.containsKey("insuretype")) transaction.setInsuretype(data.get("insuretype"));
        if (data.containsKey("custfname")) transaction.setCustfname(data.get("custfname"));
        if (data.containsKey("custlname")) transaction.setCustlname(data.get("custlname"));
        if (data.containsKey("claimdate")) transaction.setClaimdate(LocalDate.parse(data.get("claimdate")));
        if (data.containsKey("claimamt")) transaction.setClaimamt(Double.parseDouble(data.get("claimamt")));
        if (data.containsKey("claimreason")) transaction.setClaimreason(data.get("claimreason"));
        if (data.containsKey("claimdescr")) transaction.setClaimdescr(data.get("claimdescr"));
        if (data.containsKey("otherincdate")) transaction.setOtherincdate(LocalDate.parse(data.get("otherincdate")));
        if (data.containsKey("anyotherdetails")) transaction.setAnyotherdetails(data.get("anyotherdetails"));
        if (data.containsKey("claimaddress")) transaction.setClaimaddress(data.get("claimaddress"));
        if (data.containsKey("claimmake")) transaction.setClaimmake(data.get("claimmake"));
        if (data.containsKey("claimmodel")) transaction.setClaimmodel(data.get("claimmodel"));
        if (data.containsKey("claimyear")) transaction.setClaimyear(data.get("claimyear"));
        if (data.containsKey("claimanimaltype")) transaction.setClaimanimaltype(data.get("claimanimaltype"));
        if (data.containsKey("claimanimalbreed")) transaction.setClaimanimalbreed(data.get("claimanimalbreed"));

        return claimsRespository.save(transaction);
    }

}
