package com.schinta.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A UserDemand.
 */
@Entity
@Table(name = "user_demand")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class UserDemand implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 属性值:男等
     */
    @Size(max = 128)
    @ApiModelProperty(value = "属性值:男等")
    @Column(name = "property_value", length = 128)
    private String propertyValue;

    /**
     * 记录更新情况
     */
    @Size(max = 2000)
    @ApiModelProperty(value = "记录更新情况")
    @Column(name = "remark", length = 2000)
    private String remark;

    @ManyToOne    @JsonIgnoreProperties("properties")
    private WxUser wxUser;

    @ManyToOne    @JsonIgnoreProperties("demandValues")
    private BaseProperty base;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public UserDemand propertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
        return this;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    public String getRemark() {
        return remark;
    }

    public UserDemand remark(String remark) {
        this.remark = remark;
        return this;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public WxUser getWxUser() {
        return wxUser;
    }

    public UserDemand wxUser(WxUser wxUser) {
        this.wxUser = wxUser;
        return this;
    }

    public void setWxUser(WxUser wxUser) {
        this.wxUser = wxUser;
    }

    public BaseProperty getBase() {
        return base;
    }

    public UserDemand base(BaseProperty baseProperty) {
        this.base = baseProperty;
        return this;
    }

    public void setBase(BaseProperty baseProperty) {
        this.base = baseProperty;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserDemand userDemand = (UserDemand) o;
        if (userDemand.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), userDemand.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "UserDemand{" +
            "id=" + getId() +
            ", propertyValue='" + getPropertyValue() + "'" +
            ", remark='" + getRemark() + "'" +
            "}";
    }
}