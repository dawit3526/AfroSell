package com.eri.afrosell.model;
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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@DynamicInsert
@DynamicUpdate
@Table(name = "user_addresses")
@XmlRootElement
public class UserAddress implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "adress_id")
    private Long adressId;
    
    @Basic(optional = false)
    @Column(name = "user_id")
    private String userId;
    
    @Basic(optional = false)
    @Column(name = "adress")
    private String adress;
    
    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;
    
    @Basic(optional = false)
    @Column(name = "fax")
    private String fax;
    
    @Basic(optional = false)
    @Column(name = "city")
    private String city;
    
    @Basic(optional = false)
    @Column(name = "country")
    private String country;
    
    @Basic(optional = false)
    @Column(name = "status")
    private int status;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getAdressId() {
        return adressId;
    }

    public String getUserId() {
        return userId;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhone() {
        return phone;
    }

    public String getFax() {
        return fax;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public int getStatus() {
        return status;
    }

    public void setAdressId(Long adressId) {
        this.adressId = adressId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
