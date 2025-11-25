package com.siliconmount.ssrpro.dto;

import com.siliconmount.ssrpro.entity.TxnItemsEntity;

public class TxnItemMtsDTO {

    private Integer id;
    private Integer srNo;
    private String description;
    private Double quantity;
    private Double number;
    private Double length;
    private Double width;
    private Double height;
    private String unit;
    private Integer fkTxnItemId; // Foreign key reference to TxnItem
    private Double multiplyNumber;
    private String floorLiftRise;
    private int refTxnItemId;
    private double refTxnItemPercentage;

    // Constructors
    public TxnItemMtsDTO() {
    }

    public TxnItemMtsDTO(Integer id, Integer srNo, String description, Double quantity, Double number, Double length, Double width, Double height, String unit, Integer fkTxnItemId, Double multiplyNumber, String floorLiftRise, int refTxnItemId, double refTxnItemPercentage) {
        this.id = id;
        this.srNo = srNo;
        this.description = description;
        this.quantity = quantity;
        this.number = number;
        this.length = length;
        this.width = width;
        this.height = height;
        this.unit = unit;
        this.fkTxnItemId = fkTxnItemId;
        this.multiplyNumber = multiplyNumber;
        this.floorLiftRise = floorLiftRise;
        this.refTxnItemId = refTxnItemId;
        this.refTxnItemPercentage = refTxnItemPercentage;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSrNo() {
        return srNo;
    }

    public void setSrNo(Integer srNo) {
        this.srNo = srNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getFkTxnItemId() {
        return fkTxnItemId;
    }

    public void setFkTxnItemId(Integer fkTxnItemId) {
        this.fkTxnItemId = fkTxnItemId;
    }

    public Double getMultiplyNumber() {
        return multiplyNumber;
    }

    public void setMultiplyNumber(Double multiplyNumber) {
        this.multiplyNumber = multiplyNumber;
    }

    public String getFloorLiftRise() {
        return floorLiftRise;
    }

    public void setFloorLiftRise(String floorLiftRise) {
        this.floorLiftRise = floorLiftRise;
    }

    public int getRefTxnItemId() {
        return refTxnItemId;
    }

    public void setRefTxnItemId(int refTxnItemId) {
        this.refTxnItemId = refTxnItemId;
    }

    public double getRefTxnItemPercentage() {
        return refTxnItemPercentage;
    }

    public void setRefTxnItemPercentage(double refTxnItemPercentage) {
        this.refTxnItemPercentage = refTxnItemPercentage;
    }

    @Override
    public String toString() {
        return "TxnItemMtsDTO{" +
                "id=" + id +
                ", srNo=" + srNo +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", number=" + number +
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", unit='" + unit + '\'' +
                ", fkTxnItemId=" + fkTxnItemId +
                ", multiplyNumber=" + multiplyNumber +
                ", floorLiftRise='" + floorLiftRise + '\'' +
                ", refTxnItemId=" + refTxnItemId +
                ", refTxnItemPercentage=" + refTxnItemPercentage +
                '}';
    }
}

