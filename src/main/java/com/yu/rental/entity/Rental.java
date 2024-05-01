package com.yu.rental.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.howard.rentalorderdetails.entity.RentalOrderDetails;
import com.yu.rentalcategory.entity.RentalCategory;
import com.yu.rentalmyfavorite.entity.RentalMyFavorite;
import com.yu.rentalpic.entity.RentalPic;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity  //標示類別為"永續類別"
@Table(name = "rental")  //此"永續類別"對應到的表格
public class Rental {

    // 分組驗證 (ex. Add時是以自動分配的數字，但Update也許對應不到。固可使用此方法)
    public static interface AddRentalGroup{};
    public static interface UpdateRentalGroup{};


    @Id //標示為PK
    @Column(name="rno")
    @NotNull(message="租借品編號: 請勿空白", groups = {UpdateRentalGroup.class})
    @Min(value = 5001, message = "租借品編號: 不能小於{value}", groups = {UpdateRentalGroup.class})
    @Max(value = 8000, message = "租借品編號: 不能小於{value}", groups = {UpdateRentalGroup.class})
    private Integer rNo;


    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "rcatno", referencedColumnName = "rcatno") //對應rental的rCatNo
    private RentalCategory rentalCategory;


    @Column(name="rname", length=40)
    @NotEmpty(message="租借品名稱: 請勿空白", groups = {AddRentalGroup.class,UpdateRentalGroup.class})
    @Pattern(regexp = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,40}$",message = "只能是中、英文字母、數字和_ , 且長度必需在2到10之間",
            groups = {AddRentalGroup.class,UpdateRentalGroup.class})
    private String rName;


    @Column(name="rprice",columnDefinition="BigDecimal")
    @NotNull(message="租借品單價: 請勿空白", groups = {AddRentalGroup.class,UpdateRentalGroup.class})
    @DecimalMin(value = "00000", message = "租借品單價: 不能小於{value}",
            groups = {AddRentalGroup.class,UpdateRentalGroup.class})
    private BigDecimal rPrice;


    @Column(name="rsize")
    @NotNull(message="尺寸: 請勿空白", groups = {AddRentalGroup.class,UpdateRentalGroup.class})
    @Min(value = 0, message = "尺寸: 不能小於{value}", groups = {AddRentalGroup.class,UpdateRentalGroup.class})
    @Max(value = 5, message = "尺寸: 不能小於{value}", groups = {AddRentalGroup.class,UpdateRentalGroup.class})
    private Integer rSize;


    @Column(name="rcolor", length=10)
    @NotEmpty(message="顏色: 請勿空白", groups = {AddRentalGroup.class,UpdateRentalGroup.class})
    @Pattern(regexp = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$", message = "顏色: 只能是中文, 且長度必需在2到10之間",
            groups = {AddRentalGroup.class,UpdateRentalGroup.class})
    private String rColor;


    @Column(name="rinfo", length=1000)
    @NotEmpty(message="租借品資訊: 請勿空白", groups = {AddRentalGroup.class,UpdateRentalGroup.class})
    @Pattern(regexp = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,1000}$",
            message = "租借品資訊: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間",
            groups = {AddRentalGroup.class,UpdateRentalGroup.class})
    private String rInfo;


    @Column(name="rstat",columnDefinition = "TINYINT")
    @NotNull(message="租借品狀態: 請勿空白", groups = {AddRentalGroup.class,UpdateRentalGroup.class})
    @Min(value = 0, message = "租借品狀態: 不能小於{value}", groups = {AddRentalGroup.class,UpdateRentalGroup.class})
    @Max(value = 5, message = "租借品狀態: 不能小於{value}", groups = {AddRentalGroup.class,UpdateRentalGroup.class})
    private Byte rStat;


    @JsonBackReference
    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
    private Set<RentalOrderDetails> rentalOrderDetails;


    @JsonBackReference
    @OneToMany(mappedBy = "rental",cascade = CascadeType.ALL)
    private Set<RentalMyFavorite> rentalMyFavorites;


    @JsonBackReference
    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
    private Set<RentalPic> rentalPics;

    public Rental() {
    }

    public Rental(Integer rNo, String rName,BigDecimal rPrice, Integer rSize, String rColor, String rInfo, Byte rStat,
                  RentalCategory rentalCategory, Set<RentalOrderDetails> rentalOrderDetails,
                  Set<RentalMyFavorite> rentalMyFavorites, Set<RentalPic> rentalPics) {
        this.rNo = rNo;
        this.rName = rName;
        this.rPrice = rPrice;
        this.rSize = rSize;
        this.rColor = rColor;
        this.rInfo = rInfo;
        this.rStat = rStat;
        this.rentalCategory = rentalCategory;
        this.rentalOrderDetails = rentalOrderDetails;
        this.rentalMyFavorites = rentalMyFavorites;
        this.rentalPics = rentalPics;
    }


    public Integer getrNo() {
        return rNo;
    }

    public void setrNo(Integer rNo) {
        this.rNo = rNo;
    }

    public RentalCategory getRentalCategory() {
        return rentalCategory;
    }

    public void setRentalCategory(RentalCategory rentalCategory) {
        this.rentalCategory = rentalCategory;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public BigDecimal getrPrice() {
        return rPrice;
    }

    public void setrPrice(BigDecimal rPrice) {
        this.rPrice = rPrice;
    }

    public Integer getrSize() {
        return rSize;
    }

    public void setrSize(Integer rSize) {
        this.rSize = rSize;
    }

    public String getrColor() {
        return rColor;
    }

    public void setrColor(String rColor) {
        this.rColor = rColor;
    }

    public String getrInfo() {
        return rInfo;
    }

    public void setrInfo(String rInfo) {
        this.rInfo = rInfo;
    }

    public Byte getrStat() {
        return rStat;
    }

    public void setrStat(Byte rStat) {
        this.rStat = rStat;
    }

    public Set<RentalOrderDetails> getRentalOrderDetails() {
        return rentalOrderDetails;
    }

    public void setRentalOrderDetails(Set<RentalOrderDetails> rentalOrderDetails) {
        this.rentalOrderDetails = rentalOrderDetails;
    }

    public Set<RentalMyFavorite> getRentalMyFavorites() {
        return rentalMyFavorites;
    }

    public void setRentalMyFavorites(Set<RentalMyFavorite> rentalMyFavorites) {
        this.rentalMyFavorites = rentalMyFavorites;
    }

    public Set<RentalPic> getRentalPics() {
        return rentalPics;
    }

    public void setRentalPics(Set<RentalPic> rentalPics) {
        this.rentalPics = rentalPics;
    }
}