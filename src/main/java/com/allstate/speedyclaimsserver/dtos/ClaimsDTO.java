package com.allstate.speedyclaimsserver.dtos;

import com.allstate.speedyclaimsserver.domain.Claims;

import java.time.LocalDate;

public class ClaimsDTO {
    private Integer policynumber;
    private String status;
    private String insuretype;
    private String custfname;
    private String custlname;
    private LocalDate claimdate;
    private Double claimamt;
    private String claimreason;
    private String claimdescr;

    private LocalDate otherincdate;
    private String anyotherdetails;

    private String claimaddress;

    private String claimmake;
    private String claimmodel;
    private String claimyear;

    private String claimanimaltype;
    private String claimanimalbreed;

    public ClaimsDTO() {
    }

    public ClaimsDTO(Claims newcl) {
        this.policynumber = newcl.getPolicynumber();
        this.status = newcl.getStatus();
        this.insuretype = newcl.getInsuretype();
        this.custfname = newcl.getCustfname();
        this.custlname = newcl.getCustlname();
        this.claimdate = newcl.getClaimdate();
        this.claimamt = newcl.getClaimamt();
        this.claimreason = newcl.getClaimreason();
        this.claimdescr = newcl.getClaimdescr();
        this.otherincdate = newcl.getOtherincdate();
        this.anyotherdetails = newcl.getAnyotherdetails();
        this.claimaddress = newcl.getClaimaddress();
        this.claimmake = newcl.getClaimmake();
        this.claimmodel = newcl.getClaimmodel();
        this.claimyear = newcl.getClaimyear();
        this.claimanimaltype = newcl.getClaimanimaltype();
        this.claimanimalbreed = newcl.getClaimanimalbreed();
    }
    public Claims toClaims() {

        Claims newcl = new Claims(null, policynumber, status, insuretype, custfname, custlname, claimdate, claimamt, claimreason, claimdescr,
                            otherincdate, anyotherdetails, claimaddress, claimmake, claimmodel, claimyear, claimanimaltype, claimanimalbreed);
        return newcl;
    }

    public Integer getPolicynumber() {
        return policynumber;
    }

    public void setPolicynumber(Integer policynumber) {
        this.policynumber = policynumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInsuretype() {
        return insuretype;
    }

    public void setInsuretype(String insuretype) {
        this.insuretype = insuretype;
    }

    public String getCustfname() {
        return custfname;
    }

    public void setCustfname(String custfname) {
        this.custfname = custfname;
    }

    public String getCustlname() {
        return custlname;
    }

    public void setCustlname(String custlname) {
        this.custlname = custlname;
    }

    public LocalDate getClaimdate() {
        return claimdate;
    }

    public void setClaimdate(LocalDate claimdate) {
        this.claimdate = claimdate;
    }

    public Double getClaimamt() {
        return claimamt;
    }

    public void setClaimamt(Double claimamt) {
        this.claimamt = claimamt;
    }

    public String getClaimreason() {
        return claimreason;
    }

    public void setClaimreason(String claimreason) {
        this.claimreason = claimreason;
    }

    public String getClaimdescr() {
        return claimdescr;
    }

    public void setClaimdescr(String claimdescr) {
        this.claimdescr = claimdescr;
    }

    public LocalDate getOtherincdate() {
        return otherincdate;
    }

    public void setOtherincdate(LocalDate otherincdate) {
        this.otherincdate = otherincdate;
    }

    public String getAnyotherdetails() {
        return anyotherdetails;
    }

    public void setAnyotherdetails(String anyotherdetails) {
        this.anyotherdetails = anyotherdetails;
    }

    public String getClaimaddress() {
        return claimaddress;
    }

    public void setClaimaddress(String claimaddress) {
        this.claimaddress = claimaddress;
    }

    public String getClaimmake() {
        return claimmake;
    }

    public void setClaimmake(String claimmake) {
        this.claimmake = claimmake;
    }

    public String getClaimmodel() {
        return claimmodel;
    }

    public void setClaimmodel(String claimmodel) {
        this.claimmodel = claimmodel;
    }

    public String getClaimyear() {
        return claimyear;
    }

    public void setClaimyear(String claimyear) {
        this.claimyear = claimyear;
    }

    public String getClaimanimaltype() {
        return claimanimaltype;
    }

    public void setClaimanimaltype(String claimanimaltype) {
        this.claimanimaltype = claimanimaltype;
    }

    public String getClaimanimalbreed() {
        return claimanimalbreed;
    }

    public void setClaimanimalbreed(String claimanimalbreed) {
        this.claimanimalbreed = claimanimalbreed;
    }
}
