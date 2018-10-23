package com.eri.afrosell.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@DynamicInsert
@DynamicUpdate
@Table(name = "product_categories")
@XmlRootElement
public class ProductCategory {
    
    @EmbeddedId
    private ProductCategoryId id;

//    @Id
//    @Basic(optional = false)
//    @Column(name = "product_id")
//    private Long productId;
//
//    @Id
//    @Basic(optional = false)
//    @Column(name = "category_id")
//    private Long categoryId;

}
