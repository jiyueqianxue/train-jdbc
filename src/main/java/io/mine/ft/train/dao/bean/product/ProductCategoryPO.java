package io.mine.ft.train.dao.bean.product;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 *
 * @author machao
 * @date 2019-09-16
 *
 */
public class ProductCategoryPO implements Serializable {
    /**  */
    private Long id;

    /** 类目级别 */
    private Byte level;

    /** 类目名称 */
    private String categoryName;

    /**  */
    private String link;

    /**  */
    private String fontStyle;

    /** 父级ID */
    private Long parentId;

    /**  */
    private Long productId;

    /**  */
    private Date createTime;

    /**  */
    private Date updateTime;

    /** 是否删除 */
    private String isDeleted;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public String getFontStyle() {
        return fontStyle;
    }

    public void setFontStyle(String fontStyle) {
        this.fontStyle = fontStyle == null ? null : fontStyle.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", level=").append(level);
        sb.append(", categoryName=").append(categoryName);
        sb.append(", link=").append(link);
        sb.append(", fontStyle=").append(fontStyle);
        sb.append(", parentId=").append(parentId);
        sb.append(", productId=").append(productId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}