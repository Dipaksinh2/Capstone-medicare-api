package com.medicare.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;
    private String productName;
    @Column(length = 5000)
    private String productDesc;
    private Double productDiscountedPrice;
    private Double productActualPrice;
    private String productManufacturer;
    private String productCategory;
    private String productBrand;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "product_images", joinColumns = {
            @JoinColumn(name = "product_id")}, inverseJoinColumns = {
            @JoinColumn(name = "image_id")})

    private Set<ImageEntity> productImages;

    public Product() {
        super();
    }

    public Product(String productName, String productDesc, Double productDiscountedPrice, Double productActualPrice, String productManufacturer, String productCategory, String productBrand, Set<ImageEntity> productImages) {
        this.productName = productName;
        this.productDesc = productDesc;
        this.productDiscountedPrice = productDiscountedPrice;
        this.productActualPrice = productActualPrice;
        this.productManufacturer = productManufacturer;
        this.productCategory = productCategory;
        this.productBrand = productBrand;
        this.productImages = productImages;
    }

    public Set<ImageEntity> getProductImages() {
        return productImages;
    }

    public void setProductImages(Set<ImageEntity> productImages) {
        this.productImages = productImages;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Double getProductDiscountedPrice() {
        return productDiscountedPrice;
    }

    public void setProductDiscountedPrice(Double productDiscountedPrice) {
        this.productDiscountedPrice = productDiscountedPrice;
    }

    public Double getProductActualPrice() {
        return productActualPrice;
    }

    public void setProductActualPrice(Double productActualPrice) {
        this.productActualPrice = productActualPrice;
    }

    public String getProductManufacturer() {
        return productManufacturer;
    }

    public void setProductManufacturer(String productManufacturer) {
        this.productManufacturer = productManufacturer;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", productName=" + productName + ", productDesc=" + productDesc
                + ", productDiscountedPrice=" + productDiscountedPrice + ", productActualPrice=" + productActualPrice
                + "]";
    }

}
