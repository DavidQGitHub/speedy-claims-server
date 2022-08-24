package com.allstate.speedyclaimsserver.control;

import com.allstate.speedyclaimsserver.domain.Claims;
import com.allstate.speedyclaimsserver.dtos.ClaimsDTO;
import com.allstate.speedyclaimsserver.service.ClaimsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/claim")
public class ClaimsController {
    ClaimsService claimsService;

    @Autowired
    public void setClaimsService(ClaimsService claimsService) {
        this.claimsService = claimsService;
    }

    @GetMapping()
    public List<Claims> getAll(@RequestParam(value="custlname", required=false) String custlname,
                               @RequestParam(value="policynumber", required=false) Integer policynumber,
                               @RequestParam(value="status", required=false) String status) {
        if (custlname != null) {
            return claimsService.getAllTransactionsForCustlname(custlname);
        }
        else if (policynumber != null) {
            return claimsService.getAllTransactionsForPolicynumber(policynumber);
        }
        else if (status != null) {
            return claimsService.getAllTransactionsForStatus(status);
        }

        return claimsService.getAllTransactions();
    }

    @GetMapping(value ="/{claimid}", produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public Claims getById(@PathVariable("claimid") Integer claimid) {
        return claimsService.getTransactionByClaimId(claimid);
    }

    @PostMapping
    public Claims addTransaction(@RequestBody ClaimsDTO newTransaction) {
        return claimsService.add(newTransaction);
    }

    @PutMapping("/{claimid}")
    public Claims updateTransaction(@PathVariable("claimid") Integer id,
                                                   @RequestBody Map<String, String> data) {

        return claimsService.updateTransaction(id, data);
    }

}
