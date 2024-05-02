package com.iting.productorder.entity;

import com.chihyun.coupon.entity.Coupon;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.iting.productorderdetail.entity.ProductOrderDetail;
import com.roger.member.entity.Member;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "productorder")
public class ProductOrder {
    @Id
    @Column(name = "productordno", updatable = false)
    private Integer productOrdNo;
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "memno", referencedColumnName = "memno")
    private Member member;
    @Column(name = "productbyrname")
    private String productByrName;
    @Column(name = "productbyrphone")
    private String productByrPhone;
    @Column(name = "productbyremail")
    private String productByrEmail;
    @Column(name = "productrcvname")
    private String productRcvName;
    @Column(name = "productrcvphone")
    private String productRcvPhone;
    @Column(name = "producttakemethod")
    private Byte productTakeMethod;
    @Column(name = "productaddr")
    private String productAddr;
    @Column(name = "productpaymethod")
    private Byte productPayMethod;
    @Column(name = "productallprice")
    private BigDecimal productAllPrice;
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "coupno", referencedColumnName = "coupno")
    private Coupon coupon;
    @Column(name = "productdisc")
    private BigDecimal productDisc;
    @Column(name = "productrealprice")
    private BigDecimal productRealPrice;
    @Column(name = "productordtime")
    private Timestamp productOrdTime;
    @Column(name = "productordstat")
    private Byte productOrdStat;
    @Column(name = "productstat")
    private Byte productStat;
    @JsonBackReference
    @OneToMany(mappedBy = "productOrder", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Set<ProductOrderDetail> productOrderDetails;

    public ProductOrder() {
    }

    public ProductOrder(Integer productOrdNo) {
        this.productOrdNo = productOrdNo;
    }

    public ProductOrder(Member member, String productByrName, String productByrPhone, String productByrEmail, String productRcvName, String productRcvPhone, Byte productTakeMethod, String productAddr, Byte productPayMethod, BigDecimal productAllPrice, Coupon coupon, BigDecimal productDisc, BigDecimal productRealPrice, Timestamp productOrdTime, Byte productOrdStat, Byte productStat) {
        this.member = member;
        this.productByrName = productByrName;
        this.productByrPhone = productByrPhone;
        this.productByrEmail = productByrEmail;
        this.productRcvName = productRcvName;
        this.productRcvPhone = productRcvPhone;
        this.productTakeMethod = productTakeMethod;
        this.productAddr = productAddr;
        this.productPayMethod = productPayMethod;
        this.productAllPrice = productAllPrice;
        this.coupon = coupon;
        this.productDisc = productDisc;
        this.productRealPrice = productRealPrice;
        this.productOrdTime = productOrdTime;
        this.productOrdStat = productOrdStat;
        this.productStat = productStat;
    }

    public ProductOrder(Integer productOrdNo, Member member, String productByrName, String productByrPhone, String productByrEmail, String productRcvName, String productRcvPhone, Byte productTakeMethod, String productAddr, Byte productPayMethod, BigDecimal productAllPrice, Coupon coupon, BigDecimal productDisc, BigDecimal productRealPrice, Timestamp productOrdTime, Byte productOrdStat, Byte productStat) {
        this.productOrdNo = productOrdNo;
        this.member = member;
        this.productByrName = productByrName;
        this.productByrPhone = productByrPhone;
        this.productByrEmail = productByrEmail;
        this.productRcvName = productRcvName;
        this.productRcvPhone = productRcvPhone;
        this.productTakeMethod = productTakeMethod;
        this.productAddr = productAddr;
        this.productPayMethod = productPayMethod;
        this.productAllPrice = productAllPrice;
        this.coupon = coupon;
        this.productDisc = productDisc;
        this.productRealPrice = productRealPrice;
        this.productOrdTime = productOrdTime;
        this.productOrdStat = productOrdStat;
        this.productStat = productStat;
    }

    public Integer getProductOrdNo() {
        return productOrdNo;
    }

    public void setProductOrdNo(Integer productOrdNo) {
        this.productOrdNo = productOrdNo;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getProductByrName() {
        return productByrName;
    }

    public void setProductByrName(String productByrName) {
        this.productByrName = productByrName;
    }

    public String getProductByrPhone() {
        return productByrPhone;
    }

    public void setProductByrPhone(String productByrPhone) {
        this.productByrPhone = productByrPhone;
    }

    public String getProductByrEmail() {
        return productByrEmail;
    }

    public void setProductByrEmail(String productByrEmail) {
        this.productByrEmail = productByrEmail;
    }

    public String getProductRcvName() {
        return productRcvName;
    }

    public void setProductRcvName(String productRcvName) {
        this.productRcvName = productRcvName;
    }

    public String getProductRcvPhone() {
        return productRcvPhone;
    }

    public void setProductRcvPhone(String productRcvPhone) {
        this.productRcvPhone = productRcvPhone;
    }

    public Byte getProductTakeMethod() {
        return productTakeMethod;
    }

    public void setProductTakeMethod(Byte productTakeMethod) {
        this.productTakeMethod = productTakeMethod;
    }

    public String getProductAddr() {
        return productAddr;
    }

    public void setProductAddr(String productAddr) {
        this.productAddr = productAddr;
    }

    public Byte getProductPayMethod() {
        return productPayMethod;
    }

    public void setProductPayMethod(Byte productPayMethod) {
        this.productPayMethod = productPayMethod;
    }

    public BigDecimal getProductAllPrice() {
        return productAllPrice;
    }

    public void setProductAllPrice(BigDecimal productAllPrice) {
        this.productAllPrice = productAllPrice;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public BigDecimal getProductDisc() {
        return productDisc;
    }

    public void setProductDisc(BigDecimal productDisc) {
        this.productDisc = productDisc;
    }

    public BigDecimal getProductRealPrice() {
        return productRealPrice;
    }

    public void setProductRealPrice(BigDecimal productRealPrice) {
        this.productRealPrice = productRealPrice;
    }

    public Timestamp getProductOrdTime() {
        return productOrdTime;
    }

    public void setProductOrdTime(Timestamp productOrdTime) {
        this.productOrdTime = productOrdTime;
    }

    public Byte getProductOrdStat() {
        return productOrdStat;
    }

    public void setProductOrdStat(Byte productOrdStat) {
        this.productOrdStat = productOrdStat;
    }

    public Byte getProductStat() {
        return productStat;
    }

    public void setProductStat(Byte productStat) {
        this.productStat = productStat;
    }

    public Set<ProductOrderDetail> getProductOrderDetails() {
        return productOrderDetails;
    }

    public void setProductOrderDetails(Set<ProductOrderDetail> productOrderDetails) {
        this.productOrderDetails = productOrderDetails;
    }
}