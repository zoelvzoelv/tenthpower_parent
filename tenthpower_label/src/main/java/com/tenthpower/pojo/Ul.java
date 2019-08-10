package com.tenthpower.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_ul")
public class Ul {
    @Id
    private String id;

    private String userid;
    
    private Integer labelid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getLabelid() {
        return labelid;
    }

    public void setLabelid(Integer labelid) {
        this.labelid = labelid;
    }
}
