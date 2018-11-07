package com.eri.afrosell.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@DynamicInsert
@DynamicUpdate
@Table(name = "users")
@XmlRootElement
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    public String getSalt() {
        return salt;
    }

    @Id

    @Basic(optional = false)
    @Column(name = "user_id")
    private String userId;
    
    @Basic(optional = false)
    @Column(name = "company_id")
    private Long companyId;
    
    @Basic(optional = false)
    @Column(name = "role_id")
    private int roleId;
    
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Basic(optional = false)
    @Column(name = "password_hash")
    private String passwordHash;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "middle_name")
    private String middleName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    
    @JsonIgnore
    @Basic(optional = false)
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    
    @JsonIgnore
    @Basic(optional = false)
    @Column(name = "salt")
    private String salt;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUserId() {
        return userId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public int getRoleId() {
        return roleId;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getStatus() {
        return status;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getCreateDate() {
        return createDate;
    }
}
