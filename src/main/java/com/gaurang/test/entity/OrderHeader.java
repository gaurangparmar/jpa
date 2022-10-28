package com.gaurang.test.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "ORD_HDR" ,schema="ORDERS", uniqueConstraints = { @UniqueConstraint(name = "ORD_HDR_UK1", columnNames = { "ORD_ID" })})
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class OrderHeader implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ORD_HDR_ID", nullable = false, updatable = false)
    @SequenceGenerator( name = "ORD_HDR_ID_SEQ", sequenceName = "ORDERS.ORD_HDR_ID_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "ORD_HDR_ID_SEQ" )
    private int orderHeaderId;

    @Column(name = "ORD_ID", nullable = false, updatable = false, length = 10)
    private String orderId;

    @Column(name = "LAST_NAME_TX", length = 30)
    private String lastName;

    @Column(name="FRST_NAME_TX", length = 20)
    private String firstName;

    @Column(name="ADR_1_TX", length = 30)
    private String address1;

    @Column(name="ADR_2_TX", length = 30)
    private String address2;

    @Column(name="CITY_TX", length = 20)
    private String city;

    @Column(name="ST_CD", length = 3)
    private String stateCode;

    @Column(name="ZIP_CD", length = 10)
    private String zipCode;

    @Column(name="PHON_CD", length = 13)
    private String phoneCode;

    @Column(name="ORD_TYPE_CD", length = 3)
    private String orderTypeCode;

    @Column(name="DLV_DT")
    private LocalDate deliveryDate;

    @OneToOne(mappedBy = "orderHeader", fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = false)
    private OrderMeta orderMeta;
}
