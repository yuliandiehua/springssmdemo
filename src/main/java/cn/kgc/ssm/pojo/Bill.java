package cn.kgc.ssm.pojo;

import java.util.Date;

/**
 * 订单表
 */
public class Bill {
    private Integer id;//主键id
    private String billCode;//订单编号
    private String productName;//订单名称
    private String productDesc;//商品描述
    private String productUnit;//商品单位
    private Double productCount;//数量
    private Double totalPrice; //总价
    private Integer isPayment;//是否支付
    private Integer createdBy;//创建人
    private Date creationDate;//创建时间
    private Integer modifyBy;//修改人
    private Date modiDate;//修改时间
    private Integer providerId;//供应商Id

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
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

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public Double getProductCount() {
        return productCount;
    }

    public void setProductCount(Double productCount) {
        this.productCount = productCount;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getIsPayment() {
        return isPayment;
    }

    public void setIsPayment(Integer isPayment) {
        this.isPayment = isPayment;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModiDate() {
        return modiDate;
    }

    public void setModiDate(Date modiDate) {
        this.modiDate = modiDate;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", billCode='" + billCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", productUnit='" + productUnit + '\'' +
                ", productCount=" + productCount +
                ", totalPrice=" + totalPrice +
                ", isPayment=" + isPayment +
                ", createdBy=" + createdBy +
                ", creationDate=" + creationDate +
                ", modifyBy=" + modifyBy +
                ", modiDate=" + modiDate +
                ", providerId=" + providerId +
                '}';
    }
}
