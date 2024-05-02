package com.howard.rentalorder.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.howard.rentalorderdetails.entity.RentalOrderDetails;
import com.roger.member.entity.Member;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "rentalorder")
public class RentalOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rentalordno", updatable = false)
    private Integer rentalOrdNo; // -> 租借品訂單編號
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "memno", referencedColumnName = "memno")
    private Member member;
    @Column(name = "rentalbyrname")
    private String rentalByrName; // -> 訂購人姓名
    @Column(name = "rentalbyrphone")
    private String rentalByrPhone; // -> 訂購人手機號碼
    @Column(name = "rentalbyremail")
    private String rentalByrEmail; // -> 訂購人Email
    @Column(name = "rentalrcvname")
    private String rentalRcvName; // -> 收件人姓名
    @Column(name = "rentalrcvphone")
    private String rentalRcvPhone; // -> 收件人手機號碼
    @Column(name = "rentaltakemethod")
    private byte rentalTakeMethod; // -> 取貨方式
    @Column(name = "rentaladdr")
    private String rentalAddr; // -> 宅配住址
    @Column(name = "rentalpaymethod")
    private byte rentalPayMethod; // -> 付款方式
    @Column(name = "rentalallprice")
    private BigDecimal rentalAllPrice; // -> 訂單總金額
    @Column(name = "rentalalldepprice")
    private BigDecimal rentalAllDepPrice; // -> 押金總金額
    @Column(name = "rentalordtime")
    private Timestamp rentalOrdTime; // -> 下單時間
    @Column(name = "rentaldate")
    private Timestamp rentalDate; // -> 預計租借日期
    @Column(name = "rentalbackdate")
    private Timestamp rentalBackDate; // -> 預計歸還日期
    @Column(name = "rentalrealbackdate")
    private Timestamp rentalRealBackDate; // -> 實際歸還日期
    @Column(name = "rentalpaystat")
    private byte rentalPayStat; // -> 付款狀態
    @Column(name = "rentalordstat")
    private byte rentalOrdStat; // -> 訂單狀態
    @Column(name = "rtnstat")
    private byte rtnStat; // -> 歸還狀態
    @Column(name = "rtnremark")
    private String rtnRemark; // -> 歸還註記
    @Column(name = "rtncompensation")
    private BigDecimal rtnCompensation; // -> 賠償金額
    @JsonBackReference
    @OneToMany(mappedBy = "rentalOrder", cascade = CascadeType.ALL)
    private Set<RentalOrderDetails> rentalOrderDetailses;

    public RentalOrder() {
    }

    public RentalOrder(Integer rentalOrdNo) {
        this.rentalOrdNo = rentalOrdNo;
    }

    public RentalOrder(Member member, String rentalByrName, String rentalByrPhone, String rentalByrEmail, String rentalRcvName, String rentalRcvPhone, byte rentalTakeMethod, String rentalAddr, byte rentalPayMethod, BigDecimal rentalAllPrice, BigDecimal rentalAllDepPrice, Timestamp rentalOrdTime, Timestamp rentalDate, Timestamp rentalBackDate, Timestamp rentalRealBackDate, byte rentalPayStat, byte rentalOrdStat, byte rtnStat, String rtnRemark, BigDecimal rtnCompensation) {
        this.member = member;
        this.rentalByrName = rentalByrName;
        this.rentalByrPhone = rentalByrPhone;
        this.rentalByrEmail = rentalByrEmail;
        this.rentalRcvName = rentalRcvName;
        this.rentalRcvPhone = rentalRcvPhone;
        this.rentalTakeMethod = rentalTakeMethod;
        this.rentalAddr = rentalAddr;
        this.rentalPayMethod = rentalPayMethod;
        this.rentalAllPrice = rentalAllPrice;
        this.rentalAllDepPrice = rentalAllDepPrice;
        this.rentalOrdTime = rentalOrdTime;
        this.rentalDate = rentalDate;
        this.rentalBackDate = rentalBackDate;
        this.rentalRealBackDate = rentalRealBackDate;
        this.rentalPayStat = rentalPayStat;
        this.rentalOrdStat = rentalOrdStat;
        this.rtnStat = rtnStat;
        this.rtnRemark = rtnRemark;
        this.rtnCompensation = rtnCompensation;
    }

    public RentalOrder(Integer rentalOrdNo, Member member, String rentalByrName, String rentalByrPhone, String rentalByrEmail, String rentalRcvName, String rentalRcvPhone, byte rentalTakeMethod, String rentalAddr, byte rentalPayMethod, BigDecimal rentalAllPrice, BigDecimal rentalAllDepPrice, Timestamp rentalOrdTime, Timestamp rentalDate, Timestamp rentalBackDate, Timestamp rentalRealBackDate, byte rentalPayStat, byte rentalOrdStat, byte rtnStat, String rtnRemark, BigDecimal rtnCompensation) {
        this.rentalOrdNo = rentalOrdNo;
        this.member = member;
        this.rentalByrName = rentalByrName;
        this.rentalByrPhone = rentalByrPhone;
        this.rentalByrEmail = rentalByrEmail;
        this.rentalRcvName = rentalRcvName;
        this.rentalRcvPhone = rentalRcvPhone;
        this.rentalTakeMethod = rentalTakeMethod;
        this.rentalAddr = rentalAddr;
        this.rentalPayMethod = rentalPayMethod;
        this.rentalAllPrice = rentalAllPrice;
        this.rentalAllDepPrice = rentalAllDepPrice;
        this.rentalOrdTime = rentalOrdTime;
        this.rentalDate = rentalDate;
        this.rentalBackDate = rentalBackDate;
        this.rentalRealBackDate = rentalRealBackDate;
        this.rentalPayStat = rentalPayStat;
        this.rentalOrdStat = rentalOrdStat;
        this.rtnStat = rtnStat;
        this.rtnRemark = rtnRemark;
        this.rtnCompensation = rtnCompensation;
    }

    public Integer getRentalOrdNo() {
        return rentalOrdNo;
    }

    public void setRentalOrdNo(Integer rentalOrdNo) {
        this.rentalOrdNo = rentalOrdNo;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getRentalByrName() {
        return rentalByrName;
    }

    public void setRentalByrName(String rentalByrName) {
        this.rentalByrName = rentalByrName;
    }

    public String getRentalByrPhone() {
        return rentalByrPhone;
    }

    public void setRentalByrPhone(String rentalByrPhone) {
        this.rentalByrPhone = rentalByrPhone;
    }

    public String getRentalByrEmail() {
        return rentalByrEmail;
    }

    public void setRentalByrEmail(String rentalByrEmail) {
        this.rentalByrEmail = rentalByrEmail;
    }

    public String getRentalRcvName() {
        return rentalRcvName;
    }

    public void setRentalRcvName(String rentalRcvName) {
        this.rentalRcvName = rentalRcvName;
    }

    public String getRentalRcvPhone() {
        return rentalRcvPhone;
    }

    public void setRentalRcvPhone(String rentalRcvPhone) {
        this.rentalRcvPhone = rentalRcvPhone;
    }

    public byte getRentalTakeMethod() {
        return rentalTakeMethod;
    }

    public void setRentalTakeMethod(byte rentalTakeMethod) {
        this.rentalTakeMethod = rentalTakeMethod;
    }

    public String getRentalAddr() {
        return rentalAddr;
    }

    public void setRentalAddr(String rentalAddr) {
        this.rentalAddr = rentalAddr;
    }

    public byte getRentalPayMethod() {
        return rentalPayMethod;
    }

    public void setRentalPayMethod(byte rentalPayMethod) {
        this.rentalPayMethod = rentalPayMethod;
    }

    public BigDecimal getRentalAllPrice() {
        return rentalAllPrice;
    }

    public void setRentalAllPrice(BigDecimal rentalAllPrice) {
        this.rentalAllPrice = rentalAllPrice;
    }

    public BigDecimal getRentalAllDepPrice() {
        return rentalAllDepPrice;
    }

    public void setRentalAllDepPrice(BigDecimal rentalAllDepPrice) {
        this.rentalAllDepPrice = rentalAllDepPrice;
    }

    public Timestamp getRentalOrdTime() {
        return rentalOrdTime;
    }

    public void setRentalOrdTime(Timestamp rentalOrdTime) {
        this.rentalOrdTime = rentalOrdTime;
    }

    public Timestamp getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Timestamp rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Timestamp getRentalBackDate() {
        return rentalBackDate;
    }

    public void setRentalBackDate(Timestamp rentalBackDate) {
        this.rentalBackDate = rentalBackDate;
    }

    public Timestamp getRentalRealBackDate() {
        return rentalRealBackDate;
    }

    public void setRentalRealBackDate(Timestamp rentalRealBackDate) {
        this.rentalRealBackDate = rentalRealBackDate;
    }

    public byte getRentalPayStat() {
        return rentalPayStat;
    }

    public void setRentalPayStat(byte rentalPayStat) {
        this.rentalPayStat = rentalPayStat;
    }

    public byte getRentalOrdStat() {
        return rentalOrdStat;
    }

    public void setRentalOrdStat(byte rentalOrdStat) {
        this.rentalOrdStat = rentalOrdStat;
    }

    public byte getRtnStat() {
        return rtnStat;
    }

    public void setRtnStat(byte rtnStat) {
        this.rtnStat = rtnStat;
    }

    public String getRtnRemark() {
        return rtnRemark;
    }

    public void setRtnRemark(String rtnRemark) {
        this.rtnRemark = rtnRemark;
    }

    public BigDecimal getRtnCompensation() {
        return rtnCompensation;
    }

    public void setRtnCompensation(BigDecimal rtnCompensation) {
        this.rtnCompensation = rtnCompensation;
    }

    public Set<RentalOrderDetails> getRentalOrderDetailses() {
        return rentalOrderDetailses;
    }

    public void setRentalOrderDetailses(Set<RentalOrderDetails> rentalOrderDetailses) {
        this.rentalOrderDetailses = rentalOrderDetailses;
    }
}