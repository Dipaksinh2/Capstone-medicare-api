package com.medicare.entity;

import javax.persistence.*;

@Entity
@Table(name="image_model")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int imgId;
    private String imgName;
    private String imgType;

    @Column(length = 900000000)
    private byte[] imgByte;

    public ImageEntity() {
        super();
    }

    public ImageEntity(String imgName, String imgType, byte[] imgByte) {
        super();
        this.imgName = imgName;
        this.imgType = imgType;
        this.imgByte = imgByte;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgType() {
        return imgType;
    }

    public void setImgType(String imgType) {
        this.imgType = imgType;
    }

    public byte[] getImgByte() {
        return imgByte;
    }

    public void setImgByte(byte[] imgByte) {
        this.imgByte = imgByte;
    }

}

