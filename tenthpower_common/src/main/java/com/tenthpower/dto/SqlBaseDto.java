package com.tenthpower.dto;

import com.tenthpower.util.DateUtil;

import java.io.Serializable;
import java.util.Date;

public class SqlBaseDto implements Serializable {

    private static final long serialVersionUID = -6012929095434378823L;
    private String createdBy = "";//;SecurityUtils.getCurrentUserLogin();
    private Date createdDate = DateUtil.getCurDate();
    private String lastModifiedBy = "";//;SecurityUtils.getCurrentUserLogin();
    private Date lastModifiedDate = DateUtil.getCurDate();
    private Byte isDel = 0;

    public String toString() {
        return "SqlAuditBaseDto(createdBy=" + this.getCreatedBy() + ", createdDate=" + this.getCreatedDate() + ", lastModifiedBy=" + this.getLastModifiedBy() + ", lastModifiedDate=" + this.getLastModifiedDate() + ", isDel=" + this.getIsDel() + ")";
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public String getLastModifiedBy() {
        return this.lastModifiedBy;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public Byte getIsDel() {
        return this.isDel;
    }
}
