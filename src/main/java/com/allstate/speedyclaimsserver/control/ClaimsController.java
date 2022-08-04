package com.allstate.speedyclaimsserver.control;

import com.allstate.speedyclaimsserver.domain.Claims;
import com.allstate.speedyclaimsserver.service.ClaimsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
                               @RequestParam(value="policynumber", required=false) Integer policynumber) {
        if (custlname != null) {
            return claimsService.getAllTransactionsForCustlname(custlname);
        }
        else if (policynumber != null) {
            return claimsService.getAllTransactionsForPolicynumber(policynumber);
        }

        return claimsService.getAllTransactions();

    }

    @GetMapping(value ="/{claimid}", produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public Claims getById(@PathVariable("claimid") Integer claimid) {
        return claimsService.getTransactionByClaimId(claimid);
    }
}
