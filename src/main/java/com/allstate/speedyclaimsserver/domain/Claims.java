package com.allstate.speedyclaimsserver.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
//@Table(name="")
public class Claims {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer claimid;

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

    public Claims() {
    }

    public Claims(Integer claimid, Integer policynumber, String status, String insuretype, String custfname, String custlname, LocalDate claimdate, Double claimamt, String claimreason, String claimdescr, LocalDate otherincdate, String anyotherdetails, String claimaddress, String claimmake, String claimmodel, String claimyear, String claimanimaltype, String claimanimalbreed) {
        this.claimid = claimid;
        this.policynumber = policynumber;
        this.status = status;
        this.insuretype = insuretype;
        this.custfname = custfname;
        this.custlname = custlname;
        this.claimdate = claimdate;
        this.claimamt = claimamt;
        this.claimreason = claimreason;
        this.claimdescr = claimdescr;
        this.otherincdate = otherincdate;
        this.anyotherdetails = anyotherdetails;
        this.claimaddress = claimaddress;
        this.claimmake = claimmake;
        this.claimmodel = claimmodel;
        this.claimyear = claimyear;
        this.claimanimaltype = claimanimaltype;
        this.claimanimalbreed = claimanimalbreed;
    }

    @Override
    public String toString() {
        return "Claims{" +
                "claimid=" + claimid +
                ", policynumber=" + policynumber +
                ", status='" + status + '\'' +
                ", insuretype='" + insuretype + '\'' +
                ", custfname='" + custfname + '\'' +
                ", custlname='" + custlname + '\'' +
                ", claimdate=" + claimdate +
                ", claimamt=" + claimamt +
                ", claimreason='" + claimreason + '\'' +
                ", claimdescr='" + claimdescr + '\'' +
                ", otherincdate=" + otherincdate +
                ", anyotherdetails='" + anyotherdetails + '\'' +
                ", claimaddress='" + claimaddress + '\'' +
                ", claimmake='" + claimmake + '\'' +
                ", claimmodel='" + claimmodel + '\'' +
                ", claimyear='" + claimyear + '\'' +
                ", claimanimaltype='" + claimanimaltype + '\'' +
                ", claimanimalbreed='" + claimanimalbreed + '\'' +
                '}';
    }

    public Integer getClaimid() {
        return claimid;
    }

    public void setClaimid(Integer claimid) {
        this.claimid = claimid;
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

