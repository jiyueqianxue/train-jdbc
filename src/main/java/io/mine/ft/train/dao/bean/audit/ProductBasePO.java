package io.mine.ft.train.dao.bean.audit;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 
 *
 * @author Lenovo
 * @date 2019-04-27
 *
 */
public class ProductBasePO implements Serializable {
    /** 产品ID主键 */
    private Long id;

    /** 产品名称 */
    private String productName;

    /** 产品图片 */
    private String productImg;

    /** 产品描述 */
    private String productDesc;

    /** 产品状态 */
    private Byte productStatus;

    /** 类目ID */
    private Long categoryId;

    /** 类型描述 */
    private String typeDesc;

    /** 服务区域 */
    private String serviceArea;

    /** 服务提供者 */
    private String provider;

    /** 手机号 */
    private String mobilePhone;

    /** 销售价 */
    private BigDecimal salePrice;

    /** 活动价 */
    private BigDecimal activePrice;

    /** 创建时间 */
    private Timestamp createTime;

    /** 更新时间 */
    private Timestamp updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg == null ? null : productImg.trim();
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc == null ? null : productDesc.trim();
    }

    public Byte getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Byte productStatus) {
        this.productStatus = productStatus;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc == null ? null : typeDesc.trim();
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea == null ? null : serviceArea.trim();
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider == null ? null : provider.trim();
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getActivePrice() {
        return activePrice;
    }

    public void setActivePrice(BigDecimal activePrice) {
        this.activePrice = activePrice;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productName=").append(productName);
        sb.append(", productImg=").append(productImg);
        sb.append(", productDesc=").append(productDesc);
        sb.append(", productStatus=").append(productStatus);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", typeDesc=").append(typeDesc);
        sb.append(", serviceArea=").append(serviceArea);
        sb.append(", provider=").append(provider);
        sb.append(", mobilePhone=").append(mobilePhone);
        sb.append(", salePrice=").append(salePrice);
        sb.append(", activePrice=").append(activePrice);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}