package com.siliconmount.ssrpro.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "txn_item_mts")
public class TxnItemMtsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "sr_no")
    private Integer srNo;

    @Column(name = "description", length = 60)
    private String description;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name = "number")
    private Double number;

    @Column(name = "lenght")
    private Double length;

    @Column(name = "width")
    private Double width;

    @Column(name = "hight")
    private Double height;

    @Column(name = "unit", length = 45)
    private String unit;

    @Column(name = "fk_item_id")
    private Integer fkTxnItemId;

    @Column(name = "multiply_number")
    private Double multiplyNumber;

    @Column(name="floor_lift_rise")
    private String floorLiftRise;

    @Column(name = "ref_txn_item_id")
    private int refTxnItemId;

    @Column(name = "ref_txn_item_percentage")
    private double refTxnItemPercentage;

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
}

