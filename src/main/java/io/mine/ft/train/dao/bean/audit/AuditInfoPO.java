package io.mine.ft.train.dao.bean.audit;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 
 *
 * @author chao.ma
 * @date 2018-12-11
 *
 */
public class AuditInfoPO implements Serializable {
    /** ID */
    private Integer id;

    /** 申请单业务类型，枚举，0：未知，1：担保单，2：押品 */
    private Integer bizType;

    /** 业务ID：担保ID或押品ID */
    private Integer bizId;

    /** 审核员id */
    private Long auditorId;

    /** 审核员名称 */
    private String auditorName;

    /** 审核时间 */
    private Timestamp auditTime;

    /** 审核节点，如果审批流程就一个节点，默认为0, 1：担保单审核2,：入库 3：出库 */
    private Integer auditNode;

    /** 审核评语 */
    private String auditDesc;

    /** 审核结果: 0.待审核，1:通过, 2:不通过 */
    private Integer result;

    /** 所属租户ID */
    private Long tenantId;

    /** 是否删除（Y-是，N-否） */
    private String isDeleted;

    /** 创建人 */
    private String creator;

    /** 修改人 */
    private String modifier;

    /** 创建时间 */
    private Timestamp gmtCreated;

    /** 修改时间 */
    private Timestamp gmtModified;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBizType() {
        return bizType;
    }

    public void setBizType(Integer bizType) {
        this.bizType = bizType;
    }

    public Integer getBizId() {
        return bizId;
    }

    public void setBizId(Integer bizId) {
        this.bizId = bizId;
    }

    public Long getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(Long auditorId) {
        this.auditorId = auditorId;
    }

    public String getAuditorName() {
        return auditorName;
    }

    public void setAuditorName(String auditorName) {
        this.auditorName = auditorName == null ? null : auditorName.trim();
    }

    public Timestamp getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Timestamp auditTime) {
        this.auditTime = auditTime;
    }

    public Integer getAuditNode() {
        return auditNode;
    }

    public void setAuditNode(Integer auditNode) {
        this.auditNode = auditNode;
    }

    public String getAuditDesc() {
        return auditDesc;
    }

    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc == null ? null : auditDesc.trim();
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    public Timestamp getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Timestamp gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Timestamp getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Timestamp gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", bizType=").append(bizType);
        sb.append(", bizId=").append(bizId);
        sb.append(", auditorId=").append(auditorId);
        sb.append(", auditorName=").append(auditorName);
        sb.append(", auditTime=").append(auditTime);
        sb.append(", auditNode=").append(auditNode);
        sb.append(", auditDesc=").append(auditDesc);
        sb.append(", result=").append(result);
        sb.append(", tenantId=").append(tenantId);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", creator=").append(creator);
        sb.append(", modifier=").append(modifier);
        sb.append(", gmtCreated=").append(gmtCreated);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}